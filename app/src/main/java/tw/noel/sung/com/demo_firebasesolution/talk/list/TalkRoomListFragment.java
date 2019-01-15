package tw.noel.sung.com.demo_firebasesolution.talk.list;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.OnClick;
import tw.noel.sung.com.demo_firebasesolution.R;
import tw.noel.sung.com.demo_firebasesolution.talk.list.adapter.RoomAdapter;
import tw.noel.sung.com.demo_firebasesolution.talk.list.board.TalkBoardFragment;
import tw.noel.sung.com.demo_firebasesolution.talk.list.model.User;
import tw.noel.sung.com.demo_firebasesolution.talk.list.model.UserList;
import tw.noel.sung.com.demo_firebasesolution.util.base.BasePageFragment;
import tw.noel.sung.com.demo_firebasesolution.util.dialog.CreateRoomDialog;
import tw.noel.sung.com.demo_firebasesolution.util.firebase.authentication.MyAuthenticationCenter;
import tw.noel.sung.com.demo_firebasesolution.util.firebase.database.MyFirebaseDataBaseCenter;

/**
 * Created by noel on 2019/1/14.
 */
public class TalkRoomListFragment extends BasePageFragment implements ValueEventListener, CreateRoomDialog.OnTalkRoomCreateListener, RoomAdapter.OnItemClickListener {
    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    @BindView(R.id.button_create)
    Button buttonCreate;

    private RoomAdapter roomAdapter;
    private MyFirebaseDataBaseCenter myFirebaseDataBaseCenter;
    private MyAuthenticationCenter myAuthenticationCenter;
    private DatabaseReference databaseReference;
    private String myID;
    private ArrayList<UserList.RoomsBean> roomsBeans;
    //-------

    @Override
    protected int getContentView() {
        return R.layout.fragment_talk_list;
    }
    //-------

    @Override
    protected void init() {
        myFirebaseDataBaseCenter = new MyFirebaseDataBaseCenter();
        myAuthenticationCenter = new MyAuthenticationCenter(activity);
        roomAdapter = new RoomAdapter(activity);
        recyclerView.setAdapter(roomAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false));
        myID = myAuthenticationCenter.getUserId();

        roomAdapter.setOnItemClickListener(this);
    }

    //--------

    @Override
    public void onResume() {
        super.onResume();
        databaseReference = myFirebaseDataBaseCenter.getDatabaseReference().child("users").child(myID);
        databaseReference.addValueEventListener(this);
    }
    //--------

    @Override
    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
        roomsBeans = dataSnapshot.getValue(UserList.class).getRooms();
        if (roomsBeans != null) {
            roomAdapter.setData(roomsBeans);
        }
    }

    //--------

    @Override
    public void onCancelled(@NonNull DatabaseError databaseError) {

    }
    //--------

    @Override
    public void onPause() {
        super.onPause();
        databaseReference.removeEventListener(this);
    }


    //-------


    @OnClick(R.id.button_create)
    public void onViewClicked(View view) {
        new CreateRoomDialog(activity, myID).setOnTalkRoomCreateListener(this).show();
    }

    //-------

    /***
     * 按下確定 建立房間後
     * @param users
     */
    @Override
    public void onTalkRoomCreate(ArrayList<User> users) {
        myFirebaseDataBaseCenter.createRoom(users);
    }
    //-------

    @Override
    public void onItemClicked(View view, int position) {
        UserList.RoomsBean roomsBean = roomsBeans.get(position);
        Bundle bundle = new Bundle();
        bundle.putParcelable("data", roomsBean);
        replacePageFragment(R.id.frame_layout, new TalkBoardFragment(), true, bundle);
    }
}
