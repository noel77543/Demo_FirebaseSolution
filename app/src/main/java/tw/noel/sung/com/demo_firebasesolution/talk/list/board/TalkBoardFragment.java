package tw.noel.sung.com.demo_firebasesolution.talk.list.board;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import butterknife.BindView;
import butterknife.OnClick;
import tw.noel.sung.com.demo_firebasesolution.R;
import tw.noel.sung.com.demo_firebasesolution.login.LoginActivity;
import tw.noel.sung.com.demo_firebasesolution.talk.list.board.adapter.TalkBoardAdapter;
import tw.noel.sung.com.demo_firebasesolution.talk.list.board.model.Board;
import tw.noel.sung.com.demo_firebasesolution.talk.list.model.UserList;
import tw.noel.sung.com.demo_firebasesolution.util.TimeUtil;
import tw.noel.sung.com.demo_firebasesolution.util.base.BasePageFragment;
import tw.noel.sung.com.demo_firebasesolution.util.firebase.authentication.MyAuthenticationCenter;
import tw.noel.sung.com.demo_firebasesolution.util.firebase.database.MyFirebaseDataBaseCenter;

/**
 * Created by noel on 2019/1/14.
 */
public class TalkBoardFragment extends BasePageFragment implements ValueEventListener, TalkBoardAdapter.OnItemClickListener {


    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    @BindView(R.id.edit_text)
    EditText editText;
    @BindView(R.id.button_sent)
    Button buttonSent;

    private TimeUtil timeUtil;
    private UserList.RoomsBean roomsBean;
    private MyAuthenticationCenter myAuthenticationCenter;
    private MyFirebaseDataBaseCenter myFirebaseDataBaseCenter;
    private DatabaseReference databaseReference;
    private TalkBoardAdapter talkBoardAdapter;
    private ArrayList<Board> boards;
    private String roomId;
    //------------

    @Override
    protected int getContentView() {
        return R.layout.fragment_talk_board;
    }

    //-------

    @Override
    protected void init() {
        roomsBean = getArguments().getParcelable("data");
        roomId = roomsBean.getRoomId();
        timeUtil = new TimeUtil();
        myFirebaseDataBaseCenter = new MyFirebaseDataBaseCenter();
        myAuthenticationCenter = new MyAuthenticationCenter(activity);
        talkBoardAdapter = new TalkBoardAdapter(activity, myAuthenticationCenter.getUserId());
        talkBoardAdapter.setOnItemClickListener(this);
        recyclerView.setAdapter(talkBoardAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false));
        databaseReference = myFirebaseDataBaseCenter.getDatabaseReference().child("rooms").child(roomId).child("board");
    }


    //-------

    @Override
    public void onResume() {
        super.onResume();
        databaseReference.addValueEventListener(this);
    }

    @Override
    public void onPause() {
        super.onPause();
        databaseReference.removeEventListener(this);
    }


    //-------


    @OnClick(R.id.button_sent)
    public void OnClicked(View view) {
        //已登入
        if (myAuthenticationCenter.isLogin()) {
            String message = editText.getText().toString();
            if (message.trim().length() > 0) {
                editText.setText("");
                myFirebaseDataBaseCenter.sendMessage(roomId,new Board(myAuthenticationCenter.getUserId(), message, myAuthenticationCenter.getEmail(), timeUtil.getCurrentTime()), boards == null ? 0 : boards.size());
            }
        } else {
            startActivity(new Intent(activity, LoginActivity.class));
        }
    }

    //-------

    @Override
    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
        boards = dataSnapshot.getValue(new GenericTypeIndicator<ArrayList<Board>>() {
        });
        talkBoardAdapter.setData(boards);
    }
    //-------

    @Override
    public void onCancelled(@NonNull DatabaseError databaseError) {

    }
    //-------

    @Override
    public void onItemClicked(View view, int position) {
        Board board = boards.get(position);
    }
}
