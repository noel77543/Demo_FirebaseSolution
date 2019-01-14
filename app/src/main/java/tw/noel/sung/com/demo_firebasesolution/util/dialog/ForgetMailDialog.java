package tw.noel.sung.com.demo_firebasesolution.util.dialog;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import tw.noel.sung.com.demo_firebasesolution.R;

/**
 * Created by noel on 2019/1/14.
 */
public class ForgetMailDialog extends Dialog {

    @BindView(R.id.edit_text_mail)
    EditText editTextMail;
    @BindView(R.id.button_sent_mail)
    Button buttonSentMail;

    private OnSentMailListener onSentMailListener;

    public ForgetMailDialog(@NonNull Context context) {
        super(context);
        setContentView(R.layout.dialog_forget_mail);
        ButterKnife.bind(this);
    }

    //------------

    @OnClick(R.id.button_sent_mail)
    public void onViewClicked(View view) {
        if (onSentMailListener != null) {
            String mail = editTextMail.getText().toString();
            onSentMailListener.onSent(mail);
        }
    }

    //------------

    public interface OnSentMailListener {
        void onSent(String email);
    }
    //------------

    public ForgetMailDialog setOnSentMailListener(OnSentMailListener onSentMailListener) {
        this.onSentMailListener = onSentMailListener;
        return this;
    }
}
