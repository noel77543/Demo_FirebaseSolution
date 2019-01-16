package tw.noel.sung.com.demo_firebasesolution.util.firebase.authentication;

import android.content.Context;
import android.support.annotation.NonNull;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import tw.noel.sung.com.demo_firebasesolution.util.application.FirebaseSolutionApplication;

/**
 * Created by noel on 2019/1/12.
 */
public class MyAuthenticationCenter {

    private OnAuthenticationTaskHappenListener onAuthenticationTaskHappenListener;
    private FirebaseAuth firebaseAuth;
    private Context context;

    public MyAuthenticationCenter(Context context) {
        this.context = context;
        firebaseAuth = FirebaseSolutionApplication.firebaseAuth;
    }


    //---------

    /***
     * 取得user ID
     */
    public String getUserId() {
        return firebaseAuth.getCurrentUser().getUid();
    }

    //----------

    /***
     * 取得email
     */

    public String getEmail() {
        return firebaseAuth.getCurrentUser().getEmail();
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
        if (email.length() > 0 && password.length() > 0) {
            firebaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (onAuthenticationTaskHappenListener != null) {
                        onAuthenticationTaskHappenListener.onLogin(task.isSuccessful());
                    }
                }
            });
        }
    }
    //-----------

    /***
     *  登出
     */
    public void logout() {
        firebaseAuth.signOut();
    }


    //-----------

    /***
     *  註冊
     * @param email
     * @param password
     */
    public void register(final String email, final String password) {
        if (email.length() > 0 && password.length() > 0) {
            firebaseAuth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(
                            new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {

                                    if (onAuthenticationTaskHappenListener != null) {
                                        onAuthenticationTaskHappenListener.onRegistered(task.isSuccessful());
                                    }
                                }
                            });
        }
    }

    //-----------------

    /***
     * 發送忘記密碼的驗證碼至Email
     */
    public void sentResetPasswordEmail(String email) {
        if (email.length() > 0) {
            firebaseAuth.sendPasswordResetEmail(email).addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    if (onAuthenticationTaskHappenListener != null) {
                        onAuthenticationTaskHappenListener.onSentResetPasswordEmail(task.isSuccessful());
                    }
                }
            });
        }
    }

    //------------------

    public void setOnAuthenticationTaskHappenListener(OnAuthenticationTaskHappenListener onAuthenticationTaskHappenListener) {
        this.onAuthenticationTaskHappenListener = onAuthenticationTaskHappenListener;
    }

    //------------------

    public interface OnAuthenticationTaskHappenListener {
        void onRegistered(boolean isSuccess);

        void onLogin(boolean isSuccess);

        void onSentResetPasswordEmail(boolean isSuccess);
    }


}
