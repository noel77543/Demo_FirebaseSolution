package tw.noel.sung.com.demo_firebasesolution.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import tw.noel.sung.com.demo_firebasesolution.R;
import tw.noel.sung.com.demo_firebasesolution.login.actionbar.ActionBarController;
import tw.noel.sung.com.demo_firebasesolution.main.MainActivity;
import tw.noel.sung.com.demo_firebasesolution.util.dialog.ForgetMailDialog;
import tw.noel.sung.com.demo_firebasesolution.util.firebase.analytics.MyFirebaseEventCenter;
import tw.noel.sung.com.demo_firebasesolution.util.firebase.authentication.MyAuthenticationCenter;
import tw.noel.sung.com.demo_firebasesolution.util.firebase.database.MyFirebaseDataBaseCenter;

/**
 * Created by noel on 2019/1/14.
 */
public class LoginActivity extends FragmentActivity implements MyAuthenticationCenter.OnAuthenticationTaskHappenListener, ForgetMailDialog.OnSentMailListener {


    @BindView(R.id.view_action_bar)
    View viewActionBar;
    @BindView(R.id.edit_text_email)
    EditText editTextEmail;
    @BindView(R.id.edit_text_password)
    EditText editTextPassword;
    @BindView(R.id.button_login)
    Button buttonLogin;
    @BindView(R.id.button_register)
    Button buttonRegister;

    private ActionBarController actionBarController;
    private MyAuthenticationCenter myAuthenticationCenter;
    private MyFirebaseDataBaseCenter myFirebaseDataBaseCenter;
    private ForgetMailDialog forgetMailDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        myAuthenticationCenter = new MyAuthenticationCenter(this);
        myFirebaseDataBaseCenter = new MyFirebaseDataBaseCenter();
        actionBarController = new ActionBarController(this, viewActionBar);

        myAuthenticationCenter.setOnAuthenticationTaskHappenListener(this);
    }

    //-----------

    @OnClick({R.id.button_login, R.id.button_register, R.id.button_forget})
    public void OnClicked(View vIew) {
        switch (vIew.getId()) {
            //登入
            case R.id.button_login:
                myAuthenticationCenter.login(editTextEmail.getText().toString(), editTextPassword.getText().toString());
                break;
            //註冊
            case R.id.button_register:
                myAuthenticationCenter.register(editTextEmail.getText().toString(), editTextPassword.getText().toString());
                break;
            //忘記密碼
            case R.id.button_forget:
                forgetMailDialog = new ForgetMailDialog(this).setOnSentMailListener(this);
                forgetMailDialog.show();
                break;
        }
    }

    //-----------

    /***
     *  註冊成功與否
     * @param isSuccess
     */
    @Override
    public void onRegistered(boolean isSuccess) {
        String message;
        if (isSuccess) {
            message = "註冊成功";
            myFirebaseDataBaseCenter.addUser(myAuthenticationCenter.getUserId(), myAuthenticationCenter.getEmail());

        } else {
            message = "註冊失敗";
        }
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();

    }
    //-----------

    /***
     *  登入成功與否
     * @param isSuccess
     */
    @Override
    public void onLogin(boolean isSuccess) {
        String message;
        if (isSuccess) {
            message = "登入成功";
            startActivity(new Intent(this, MainActivity.class));
            finish();
        } else {
            message = "登入失敗";
        }
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
    //-----------

    /***
     *  發送驗證信成功與否
     * @param isSuccess
     */
    @Override
    public void onSentResetPasswordEmail(boolean isSuccess) {
        forgetMailDialog.dismiss();
        String message;
        if (isSuccess) {
            message = "已發送驗證信至您的信箱";
        } else {
            message = "驗證信發送失敗";
        }
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    //-----------

    /***
     *  當按下發送驗證碼
     * @param email
     */
    @Override
    public void onSent(String email) {
        myAuthenticationCenter.sentResetPasswordEmail(email);
    }
}
