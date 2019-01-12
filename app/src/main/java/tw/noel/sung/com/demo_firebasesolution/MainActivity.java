package tw.noel.sung.com.demo_firebasesolution;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.View;

import butterknife.BindView;
import butterknife.ButterKnife;
import tw.noel.sung.com.demo_firebasesolution.actionbar.ActionBarController;
import tw.noel.sung.com.demo_firebasesolution.navigation.NavigationController;

public class MainActivity extends FragmentActivity implements ActionBarController.OnMenuClickListener {

    @BindView(R.id.drawer_layout)
    DrawerLayout drawerLayout;
    @BindView(R.id.view_navigation)
    View viewNavigation;
    @BindView(R.id.view_action_bar)
    View viewActionBar;

    private NavigationController navigationController;
    private ActionBarController actionBarController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        Fabric.with(this, new Crashlytics());
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        navigationController = new NavigationController(viewNavigation);
        actionBarController = new ActionBarController(viewActionBar);
        actionBarController.setOnMenuClickListener(this);
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
}
