package tw.noel.sung.com.demo_firebasesolution.util.firebase.database;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import tw.noel.sung.com.demo_firebasesolution.talk.list.model.Talk;
import tw.noel.sung.com.demo_firebasesolution.util.application.FirebaseSolutionApplication;

/**
 * Created by noel on 2019/1/14.
 */
public class MyFirebaseDataBaseCenter  {
    private DatabaseReference databaseReference;
    private DataSnapshot dataSnapshot;

    public MyFirebaseDataBaseCenter() {
        databaseReference = FirebaseSolutionApplication.databaseReference;

//        Talk.RoomsBean roomsBean =   new Talk.RoomsBean();
//        roomsBean.setHost("TTT");
//        roomsBean.setGuest("AAA");
//        roomsBean.setAgent("CCC");
//        roomsBean.setRoomId("UUU");
//        roomsBean.setBoard(new ArrayList<Talk.RoomsBean.BoardBean>());
//
////        建立以指定key為TTT索引的項目
//        databaseReference.child("rooms").child("TTT").setValue(roomsBean);
//
//
//
//        Talk.UsersBean usersBean = new Talk.UsersBean();
//        usersBean.setId(databaseReference.push().getKey());
//        usersBean.setName("D先生");
//        usersBean.setRooms(new ArrayList<Talk.UsersBean.RoomsBeanX>());
//
//        databaseReference.child("users").child("3").setValue(usersBean);

    }


    //--------------

    /***
     * 新增使用者
     */
    public void addUser(String userId,String userName,int usersSize){

        Talk.UsersBean usersBean = new Talk.UsersBean();
        usersBean.setId(userId);
        usersBean.setName(userName);
        usersBean.setRooms(new ArrayList<Talk.UsersBean.RoomsBean>());
        databaseReference.child("users").child(String.valueOf(usersSize)).setValue(usersBean);
    }


//    //-------------
//    /***
//     * 自行創建所屬聊天室
//     */
//
//    public void addRoomForUserAsHolder(,int roomsSize){
//
////        Talk.UsersBean.RoomsBean roomsBean = new Talk.UsersBean.RoomsBean();
////        roomsBean.setIsAgent(false);
////        roomsBean.setIsHolder(true);
////        roomsBean.setRoomId(databaseReference.push().getKey());
////        databaseReference.child("users").child(String.valueOf(roomsSize)).setValue(roomsBean);
//    }




    //--------------

    /***
     * 新增所有聊天室
     */
    public void addRoom(){

    }



    //---------------

    /***
     * 監聽節點內資料變化
     * @param roots  每一個字串代表每一層節點
     *               以此demo的資料結構
     *               如果要監聽指定聊天室的聊天內容
     *               new String[]{"rooms","0","board"};
     */
    public void addClidListener(ChildEventListener childEventListener,String[] roots){
        databaseReference = FirebaseSolutionApplication.databaseReference;
        for (int i = 0; i < roots.length; i++) {
            databaseReference = databaseReference.child(roots[i]);
        }
        databaseReference.addChildEventListener(childEventListener);
    }

    //----------------

    /***
     * 移除節點內資料變化的監聽器
     */
    public void removeCildListener(ChildEventListener childEventListener,String[] roots){
        databaseReference = FirebaseSolutionApplication.databaseReference;
        for (int i = 0; i < roots.length; i++) {
            databaseReference = databaseReference.child(roots[i]);
        }
        databaseReference.removeEventListener(childEventListener);
    }
    //---------------

    /***
     * 監聽所有資料變化
     */
    public void addValueEventListener(ValueEventListener valueEventListener){
        databaseReference.addValueEventListener(valueEventListener);
    }

    //----------------

    /***
     * 移除所有資料變化的監聽器
     */
    public void removeValueEventListener(ValueEventListener valueEventListener){
        databaseReference.removeEventListener(valueEventListener);
    }




//    //-------------
//
//    /***
//     *  使用者 發送字串訊息
//     * @param boardBean
//     */
//    public void sendMessage(Navigation.BoardBean boardBean, int index) {
//        DatabaseReference newRef = databaseReference.child("Board").child(String.valueOf(index));
//        newRef.setValue(boardBean);
//    }

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

