package tw.noel.sung.com.demo_firebasesolution.util.firebase.authentication;

import android.content.Context;
import android.support.annotation.NonNull;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import tw.noel.sung.com.demo_firebasesolution.util.application.FirebaseSolutionApplication;

public class MyAuthenticationCenter {

    private FirebaseAuth firebaseAuth;
    private Context context;

    public MyAuthenticationCenter(Context context) {
        this.context = context;
        firebaseAuth = FirebaseSolutionApplication.firebaseAuth;
    }

    //-----------

    /***
     * 是否已經登入
     * @return
     */
    public boolean isLogin() {
        return firebaseAuth.getCurrentUser() != null;
    }


    //-----------

    /***
     * 登入
     * @param email
     * @param password
     */
    public void login(String email, String password) {
        firebaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                String message;
                //成功登入
                if (task.isSuccessful()) {
                    message = "登入成功";
                } else {
                    message = "登入失敗";
                }
                Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
            }
        });
    }


    //-----------

    /***
     *  註冊
     * @param email
     * @param password
     */
    private void register(final String email, final String password) {
        firebaseAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(
                        new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                String message;
                                //成功註冊
                                if (task.isSuccessful()) {
                                    message = "註冊成功";
                                } else {
                                    message = "註冊失敗";
                                }
                                Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
                            }
                        });
    }
}
