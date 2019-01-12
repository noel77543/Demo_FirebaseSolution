package tw.noel.sung.com.demo_firebasesolution.navigation;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import tw.noel.sung.com.demo_firebasesolution.R;

public class NavigationController {

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    @BindView(R.id.edit_text)
    EditText editText;
    @BindView(R.id.button_sent)
    Button buttonSent;

    public NavigationController(View view) {
        ButterKnife.bind(this, view);

    }

    //------------------------------

    @OnClick(R.id.button_sent)
    public void OnClicked(View view) {
        if (editText.getText().toString().length() > 0) {
            Log.e("TTT", "TTT");

        }
    }

}
