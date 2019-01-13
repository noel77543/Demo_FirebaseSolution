package tw.noel.sung.com.demo_firebasesolution.login.actionbar;

import android.content.Context;
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
    private Context context;

    public ActionBarController(Context context, View view) {
        ButterKnife.bind(this, view);
        this.context = context;
        buttonMenu.setVisibility(View.INVISIBLE);
    }

}
