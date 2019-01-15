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
    private OnTalkRoomCreateListener onTalkRoomCreateListener;

    public CreateRoomDialog(@NonNull Context context, String myID) {
        super(context);
        setContentView(R.layout.dialog_create_room);
        ButterKnife.bind(this);
        this.myID = myID;
        textViewMine.setText(myID);
    }

    //--------
    @OnClick(R.id.button_complete)
    public void onViewClicked() {
        ArrayList<User> users = new ArrayList<>();
        User user1 = new User(myID, MyFirebaseDataBaseCenter._TYPE_HOMEOWNER);
        User user2 = new User(editTextAgent.getText().toString(), MyFirebaseDataBaseCenter._TYPE_AGENT);
        User user3 = new User(editTextGuest.getText().toString(), MyFirebaseDataBaseCenter._TYPE_GUEST);
        users.add(user1);
        users.add(user2);
        users.add(user3);
        onTalkRoomCreateListener.onTalkRoomCreate(users);
        dismiss();
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
