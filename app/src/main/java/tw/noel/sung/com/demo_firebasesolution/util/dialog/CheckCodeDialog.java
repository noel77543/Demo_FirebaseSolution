package tw.noel.sung.com.demo_firebasesolution.util.dialog;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.OnClick;
import tw.noel.sung.com.demo_firebasesolution.R;

public class CheckCodeDialog extends Dialog {
    @BindView(R.id.edit_text_code)
    EditText editTextCode;
    @BindView(R.id.edit_text_new_password)
    EditText editTextNewPassword;
    @BindView(R.id.button_code)
    Button buttonCode;

    private OnAgreeChangePasswordListener onAgreeChangePasswordListener;

    public CheckCodeDialog(@NonNull Context context) {
        super(context);
        setContentView(R.layout.dialog_forget_code);
    }
    //-----------

    @OnClick(R.id.button_code)
    public void onViewClicked(View view) {
        if (onAgreeChangePasswordListener != null) {
            if(isInputCode() & isInputNewPassword()){
                onAgreeChangePasswordListener.onAgreeChangePassword(editTextCode.getText().toString(),editTextNewPassword.getText().toString());
            }
        }
    }

    //-----------

    private boolean isInputCode() {
        boolean isInputCode = editTextCode.getText().toString().length() > 0;
        editTextCode.setError(isInputCode ? null : "必填欄位");
        return isInputCode;
    }


    //-----------

    private boolean isInputNewPassword() {
        boolean isInputNewPassword = editTextNewPassword.getText().toString().length() > 0;
        editTextNewPassword.setError(isInputNewPassword ? null : "必填欄位");
        return isInputNewPassword;
    }


    //-----------

    public interface OnAgreeChangePasswordListener {
        void onAgreeChangePassword(String code, String newPassword);
    }

    public CheckCodeDialog setOnAgreeChangePasswordListener(OnAgreeChangePasswordListener onAgreeChangePasswordListener) {
        this.onAgreeChangePasswordListener = onAgreeChangePasswordListener;
        return this;
    }
}
