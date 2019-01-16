package tw.noel.sung.com.demo_firebasesolution.util.dialog;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import tw.noel.sung.com.demo_firebasesolution.R;
import tw.noel.sung.com.demo_firebasesolution.talk.list.model.User;
import tw.noel.sung.com.demo_firebasesolution.util.TimeUtil;
import tw.noel.sung.com.demo_firebasesolution.util.firebase.database.MyFirebaseDataBaseCenter;

public class CreateRoomDialog extends Dialog {

    @BindView(R.id.text_view_mine)
    TextView textViewMine;
    @BindView(R.id.edit_text_agent)
    EditText editTextAgent;
    @BindView(R.id.edit_text_guest)
    EditText editTextGuest;
    @BindView(R.id.button_complete)
    Button buttonComplete;

    private String myID;
    private TimeUtil timeUtil;
    private OnTalkRoomCreateListener onTalkRoomCreateListener;

    public CreateRoomDialog(@NonNull Context context, String myID) {
        super(context);
        setContentView(R.layout.dialog_create_room);
        ButterKnife.bind(this);
        this.myID = myID;
        timeUtil = new TimeUtil();
        textViewMine.setText(myID);
    }

    //--------
    @OnClick(R.id.button_complete)
    public void onViewClicked() {

        String guestID = editTextGuest.getText().toString();
        String agentID = editTextAgent.getText().toString();

        if (isCheckGuest(guestID)) {

            ArrayList<User> users = new ArrayList<>();
            users.add(new User(myID, MyFirebaseDataBaseCenter._TYPE_HOMEOWNER,timeUtil.getCurrentTime()));
            if (agentID.length() > 0) {
                users.add(new User(agentID, MyFirebaseDataBaseCenter._TYPE_AGENT,timeUtil.getCurrentTime()));
            }
            users.add(new User(guestID, MyFirebaseDataBaseCenter._TYPE_GUEST,timeUtil.getCurrentTime()));
            onTalkRoomCreateListener.onTalkRoomCreate(users);
            dismiss();
        }
    }

    //---------

    private boolean isCheckGuest(String guestID) {
        boolean isInput = guestID.length() > 0;
        if (!isInput) {
            editTextGuest.setError("必填欄位");
        }
        return isInput;
    }


    //---------

    public interface OnTalkRoomCreateListener {
        void onTalkRoomCreate(ArrayList<User> users);
    }

    //---------

    public CreateRoomDialog setOnTalkRoomCreateListener(OnTalkRoomCreateListener onTalkRoomCreateListener) {
        this.onTalkRoomCreateListener = onTalkRoomCreateListener;
        return this;
    }
}
