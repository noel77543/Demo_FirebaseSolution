package tw.noel.sung.com.demo_firebasesolution.login;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import tw.noel.sung.com.demo_firebasesolution.R;
import tw.noel.sung.com.demo_firebasesolution.login.actionbar.ActionBarController;
import tw.noel.sung.com.demo_firebasesolution.util.dialog.CheckCodeDialog;
import tw.noel.sung.com.demo_firebasesolution.util.dialog.ForgetMailDialog;
import tw.noel.sung.com.demo_firebasesolution.util.firebase.analytics.MyFirebaseEventCenter;
import tw.noel.sung.com.demo_firebasesolution.util.firebase.authentication.MyAuthenticationCenter;

public class LoginActivity extends FragmentActivity implements MyAuthenticationCenter.OnAuthenticationTaskHappenListener, ForgetMailDialog.OnSentMailListener, CheckCodeDialog.OnAgreeChangePasswordListener {


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

    private MyFirebaseEventCenter myFirebaseEventCenter;
    private ActionBarController actionBarController;
    private MyAuthenticationCenter myAuthenticationCenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        myAuthenticationCenter = new MyAuthenticationCenter(this);
        myFirebaseEventCenter = new MyFirebaseEventCenter(this);
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
                new ForgetMailDialog(this).setOnSentMailListener(this).show();
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
        String message;
        if (isSuccess) {
            message = "已發送驗證信至您的信箱";
            new CheckCodeDialog(this).setOnAgreeChangePasswordListener(this).show();
        } else {
            message = "驗證信發送失敗";
        }
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
    //-----------

    /***
     *   更改密碼成功與否
     * @param isSuccess
     */
    @Override
    public void onConfirmResetPassword(boolean isSuccess) {
        String message;
        if (isSuccess) {
            message = "已成功更改密碼";
        } else {
            message = "更改密碼失敗";
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
    //-----------

    /***
     * 當按下確認更改密碼
     * @param code
     * @param newPassword
     */
    @Override
    public void onAgreeChangePassword(String code, String newPassword) {
        myAuthenticationCenter.confirmResetPassword(code, newPassword);
    }
}
