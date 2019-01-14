package tw.noel.sung.com.demo_firebasesolution.talk.list.board;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.OnClick;
import tw.noel.sung.com.demo_firebasesolution.R;
import tw.noel.sung.com.demo_firebasesolution.login.LoginActivity;
import tw.noel.sung.com.demo_firebasesolution.util.base.BasePageFragment;
import tw.noel.sung.com.demo_firebasesolution.util.firebase.authentication.MyAuthenticationCenter;

/**
 * Created by noel on 2019/1/14.
 */
public class TalkBoardFragment extends BasePageFragment {


    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    @BindView(R.id.edit_text)
    EditText editText;
    @BindView(R.id.button_sent)
    Button buttonSent;

    private MyAuthenticationCenter myAuthenticationCenter;


    //------------

    @Override
    protected int getContentView() {
        return R.layout.fragment_talk_board;
    }

    //-------

    @Override
    protected void init() {
        myAuthenticationCenter = new MyAuthenticationCenter(activity);
    }

    //-------


    @OnClick(R.id.button_sent)
    public void OnClicked(View view) {
        //已登入
        if (myAuthenticationCenter.isLogin()) {
            if (editText.getText().toString().length() > 0) {

            }
        } else {
            startActivity(new Intent(activity, LoginActivity.class));
        }
    }


}
