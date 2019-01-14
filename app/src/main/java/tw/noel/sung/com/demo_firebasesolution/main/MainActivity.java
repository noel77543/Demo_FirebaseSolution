package tw.noel.sung.com.demo_firebasesolution.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.util.Log;
import android.view.View;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import tw.noel.sung.com.demo_firebasesolution.R;
import tw.noel.sung.com.demo_firebasesolution.main.actionbar.ActionBarController;
import tw.noel.sung.com.demo_firebasesolution.main.navigation.NavigationController;
import tw.noel.sung.com.demo_firebasesolution.talk.TalkActivity;
import tw.noel.sung.com.demo_firebasesolution.util.firebase.analytics.MyFirebaseEventCenter;

/**
 * Created by noel on 2019/1/12.
 */
public class MainActivity extends FragmentActivity implements ActionBarController.OnMenuClickListener, DrawerLayout.DrawerListener {

    @BindView(R.id.drawer_layout)
    DrawerLayout drawerLayout;
    @BindView(R.id.view_navigation)
    View viewNavigation;
    @BindView(R.id.view_action_bar)
    View viewActionBar;

    private NavigationController navigationController;
    private ActionBarController actionBarController;
    private MyFirebaseEventCenter myFirebaseEventCenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        myFirebaseEventCenter = new MyFirebaseEventCenter(this);
        navigationController = new NavigationController(this, viewNavigation);
        actionBarController = new ActionBarController(this, viewActionBar);
        actionBarController.setOnMenuClickListener(this);
        drawerLayout.addDrawerListener(this);
    }

    //-------------

    @OnClick(R.id.button_talk)
    public void OnClicked(View view) {
        startActivity(new Intent(this, TalkActivity.class));
    }


    //-------------

    /***
     * 點擊menu
     */
    @Override
    public void onMenuClicked() {

        //如果 menu是打開的
        if (drawerLayout.isDrawerVisible(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            drawerLayout.openDrawer(GravityCompat.START);
        }
    }

    //--------------

    @Override
    public void onDrawerSlide(@NonNull View view, float v) {

    }
    //--------------

    /***
     * 菜單開啟
     * @param view
     */
    @Override
    public void onDrawerOpened(@NonNull View view) {
        myFirebaseEventCenter.sentEvent(MyFirebaseEventCenter.VIEW_MAIN, MyFirebaseEventCenter.CLASS_MAIN, MyFirebaseEventCenter.ACTION_MAIN_MENU_OPEN);
    }
    //--------------

    /***
     * 菜單關閉
     * @param view
     */
    @Override
    public void onDrawerClosed(@NonNull View view) {
        myFirebaseEventCenter.sentEvent(MyFirebaseEventCenter.VIEW_MAIN, MyFirebaseEventCenter.CLASS_MAIN, MyFirebaseEventCenter.ACTION_MAIN_MENU_CLOSE);
    }
    //--------------

    @Override
    public void onDrawerStateChanged(int i) {

    }
}
