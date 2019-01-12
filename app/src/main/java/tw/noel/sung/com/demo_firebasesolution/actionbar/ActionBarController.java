package tw.noel.sung.com.demo_firebasesolution.actionbar;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import tw.noel.sung.com.demo_firebasesolution.R;

public class ActionBarController {

    @BindView(R.id.button_menu)
    Button buttonMenu;
    @BindView(R.id.text_view_title)
    TextView textViewTitle;

    private OnMenuClickListener onMenuClickListener;

    public ActionBarController(View view) {
        ButterKnife.bind(this, view);

    }

    //----------------

    @OnClick(R.id.button_menu)
    public void OnClicked(View view) {
        if (onMenuClickListener != null) {
            onMenuClickListener.onMenuClicked();
        }
    }
    //------------------

    public interface OnMenuClickListener {
        void onMenuClicked();
    }
    //---------------

    public void setOnMenuClickListener(OnMenuClickListener onMenuClickListener) {
        this.onMenuClickListener = onMenuClickListener;
    }
}
