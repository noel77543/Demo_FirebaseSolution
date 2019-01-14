package tw.noel.sung.com.demo_firebasesolution.talk;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.view.View;

import butterknife.BindView;
import butterknife.ButterKnife;
import tw.noel.sung.com.demo_firebasesolution.R;
import tw.noel.sung.com.demo_firebasesolution.login.actionbar.ActionBarController;
import tw.noel.sung.com.demo_firebasesolution.talk.list.TalkRoomListFragment;
import tw.noel.sung.com.demo_firebasesolution.util.firebase.database.MyFirebaseDataBaseCenter;


/**
 * Created by noel on 2019/1/14.
 */
public class TalkActivity extends FragmentActivity {

    @BindView(R.id.view_action_bar)
    View viewActionBar;
    private ActionBarController actionBarController;
    private MyFirebaseDataBaseCenter myFirebaseDataBaseCenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_talk);
        ButterKnife.bind(this);
        myFirebaseDataBaseCenter = new MyFirebaseDataBaseCenter();
        actionBarController = new ActionBarController(this, viewActionBar);

        replaceFragment(new TalkRoomListFragment(), null);
    }
    //---------

    /***
     *  替換Fragment
     * @param fragment
     * @param bundle
     */
    private void replaceFragment(Fragment fragment, Bundle bundle) {
        if (bundle != null) {
            fragment.setArguments(bundle);
        }
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout, fragment).commit();
    }
}
