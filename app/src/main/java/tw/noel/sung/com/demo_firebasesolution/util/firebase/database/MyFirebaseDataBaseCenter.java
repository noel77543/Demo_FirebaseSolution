package tw.noel.sung.com.demo_firebasesolution.util.firebase.database;

import android.support.annotation.IntDef;
import android.support.annotation.NonNull;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;

import tw.noel.sung.com.demo_firebasesolution.talk.list.board.model.Board;
import tw.noel.sung.com.demo_firebasesolution.talk.list.model.User;
import tw.noel.sung.com.demo_firebasesolution.talk.list.model.UserList;
import tw.noel.sung.com.demo_firebasesolution.util.application.FirebaseSolutionApplication;

/**
 * Created by noel on 2019/1/14.
 */
public class MyFirebaseDataBaseCenter {
    //房東
    public static final int _TYPE_HOMEOWNER = 1;
    //代理人
    public static final int _TYPE_AGENT = 2;
    //房客
    public static final int _TYPE_GUEST = 3;

    @Retention(RetentionPolicy.SOURCE)
    @IntDef({_TYPE_HOMEOWNER, _TYPE_AGENT, _TYPE_GUEST})
    public @interface UserType {
    }

    private DatabaseReference databaseReference;

    public MyFirebaseDataBaseCenter() {
        databaseReference = FirebaseSolutionApplication.databaseReference;
    }

    public DatabaseReference getDatabaseReference() {
        return FirebaseSolutionApplication.databaseReference;
    }

    //--------------

    /***
     * 新註冊的會員都要跑這隻新增使用者
     */
    public void addUser(String userId, String userName) {
        databaseReference = FirebaseSolutionApplication.databaseReference;
        UserList userList = new UserList();
        userList.setName(userName);
        databaseReference.child("users").child(userId).setValue(userList);
    }

    //--------------

    /***
     * 使用者創建房間
     */
    public void createRoom(ArrayList<User> users) {
        databaseReference = FirebaseSolutionApplication.databaseReference;
        final String roomID = databaseReference.push().getKey();

        buildRoom(roomID, users);
        for (int i = 0; i < users.size(); i++) {
            final User user = users.get(i);

            final DatabaseReference childDatabaseReference = databaseReference.child("users").child(user.getUserId());
            childDatabaseReference.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                    int index;
                    UserList userList = dataSnapshot.getValue(UserList.class);
                    ArrayList<UserList.RoomsBean> roomsBeans = userList.getRooms();
                    index = roomsBeans.size();
                    UserList.RoomsBean roomsBean = new UserList.RoomsBean();
                    roomsBean.setType(user.getType());
                    roomsBean.setRoomId(roomID);
                    childDatabaseReference.child("rooms").child(String.valueOf(index)).setValue(roomsBean);
                    childDatabaseReference.removeEventListener(this);


                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
        }


    }
    //-------------

    /***
     * 在所有房間列表建立全新的房間病定義房間成員身份
     */
    private void buildRoom(String roomId, ArrayList<User> users) {
        DatabaseReference childDatabaseReference = databaseReference.child("rooms").child(roomId);

        //建立一個空的model 聊天版
        childDatabaseReference.child("board").child("0").setValue(new Board("", "", "", ""));
        for (int i = 0; i < users.size(); i++) {
            childDatabaseReference.child("users").child(String.valueOf(i)).setValue(users.get(i));
        }


    }

    //------------
    /***
     * 發送訊息
     */

    public void sendMessage(DatabaseReference childDatabaseReference,Board board, int index) {
        childDatabaseReference.child(String.valueOf(index)).setValue(board);
    }


    //---------------

    /***
     * 監聽所有資料變化
     */
    public void addValueEventListener(ValueEventListener valueEventListener) {
        databaseReference.addValueEventListener(valueEventListener);
    }

    //----------------

    /***
     * 移除所有資料變化的監聽器
     */
    public void removeValueEventListener(ValueEventListener valueEventListener) {
        databaseReference.removeEventListener(valueEventListener);
    }




    //--------------


//    @Override
//    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//        this.dataSnapshot = dataSnapshot;

//        Talk talk = dataSnapshot.getValue(Talk.class);
//        Log.e("TTT", talk.getRooms().get(0).getRoomId());

//        onFirebaseDataChangeListener.onFirebaseDataChange(dataSnapshot.getValue(Talk.class));
//    }

    //----------

//    @Override
//    public void onCancelled(@NonNull DatabaseError databaseError) {
//
//    }


//    //-----------------
//    public interface OnFirebaseDataChangeListener {
//        void onFirebaseDataChange(Navigation navigation);
//    }
//
//    public void setOnFirebaseDataChangeListener(OnFirebaseDataChangeListener onFirebaseDataChangeListener) {
//        this.onFirebaseDataChangeListener = onFirebaseDataChangeListener;
//    }
}

