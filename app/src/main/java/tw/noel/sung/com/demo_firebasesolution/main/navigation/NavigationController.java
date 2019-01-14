package tw.noel.sung.com.demo_firebasesolution.main.navigation;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseUser;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import tw.noel.sung.com.demo_firebasesolution.R;
import tw.noel.sung.com.demo_firebasesolution.login.LoginActivity;
import tw.noel.sung.com.demo_firebasesolution.util.application.FirebaseSolutionApplication;
import tw.noel.sung.com.demo_firebasesolution.util.firebase.authentication.MyAuthenticationCenter;

/**
 * Created by noel on 2019/1/13.
 */
public class NavigationController {


    public NavigationController(Context context, View view) {
        ButterKnife.bind(this, view);
    }


}
