package tw.noel.sung.com.demo_firebasesolution.login;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import tw.noel.sung.com.demo_firebasesolution.R;
import tw.noel.sung.com.demo_firebasesolution.login.actionbar.ActionBarController;
import tw.noel.sung.com.demo_firebasesolution.util.firebase.analytics.MyFirebaseEventCenter;

public class LoginActivity extends FragmentActivity {


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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        myFirebaseEventCenter = new MyFirebaseEventCenter(this);
        actionBarController = new ActionBarController(this, viewActionBar);

    }

    //-----------

    @OnClick(R.id.button_login)
    public void OnClicked(View vIew) {

    }
}
