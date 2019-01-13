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

public class NavigationController {

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    @BindView(R.id.edit_text)
    EditText editText;
    @BindView(R.id.button_sent)
    Button buttonSent;

    private Context context;
    private MyAuthenticationCenter myAuthenticationCenter;

    public NavigationController(Context context, View view) {
        ButterKnife.bind(this, view);
        this.context = context;
        myAuthenticationCenter = new MyAuthenticationCenter(context);
    }

    //------------------------------

    @OnClick(R.id.button_sent)
    public void OnClicked(View view) {
        //已登入
        if (myAuthenticationCenter.isLogin()) {
            if (editText.getText().toString().length() > 0) {

            }
        } else {
            context.startActivity(new Intent(context, LoginActivity.class));
        }
    }

}
