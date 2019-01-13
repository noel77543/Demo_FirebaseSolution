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

public class NavigationController {

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    @BindView(R.id.edit_text)
    EditText editText;
    @BindView(R.id.button_sent)
    Button buttonSent;

    private Context context;

    public NavigationController(Context context, View view) {
        ButterKnife.bind(this, view);
        this.context = context;
    }

    //------------------------------

    @OnClick(R.id.button_sent)
    public void OnClicked(View view) {
        //未登入
        if (FirebaseSolutionApplication.firebaseAuth.getCurrentUser() == null) {
            context.startActivity(new Intent(context, LoginActivity.class));
            return;
        }


        if (editText.getText().toString().length() > 0) {

        }
    }

}
