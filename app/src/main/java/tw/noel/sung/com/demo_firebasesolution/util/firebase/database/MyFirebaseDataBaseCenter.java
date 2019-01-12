package tw.noel.sung.com.demo_firebasesolution.util.firebase.database;

import android.support.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import tw.noel.sung.com.demo_firebasesolution.navigation.model.Navigation;
import tw.noel.sung.com.demo_firebasesolution.util.application.FirebaseSolutionApplication;


public class MyFirebaseDataBaseCenter implements ValueEventListener {
    private DatabaseReference databaseReference;
    private OnFirebaseDataChangeListener onFirebaseDataChangeListener;
    private DataSnapshot dataSnapshot;

    public MyFirebaseDataBaseCenter() {
        databaseReference = FirebaseSolutionApplication.databaseReference;
        databaseReference.addValueEventListener(this);
    }


    //-------------

    /***
     *  使用者 發送字串訊息
     * @param boardBean
     */
    public void sendMessage(Navigation.BoardBean boardBean, int index) {
        DatabaseReference newRef = databaseReference.child("Board").child(String.valueOf(index));
        newRef.setValue(boardBean);
    }

    //--------------


    @Override
    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
        this.dataSnapshot = dataSnapshot;
        onFirebaseDataChangeListener.onFirebaseDataChange(dataSnapshot.getValue(Navigation.class));
    }

    //----------

    @Override
    public void onCancelled(@NonNull DatabaseError databaseError) {

    }


    //-----------------
    public interface OnFirebaseDataChangeListener {
        void onFirebaseDataChange(Navigation navigation);
    }

    public void setOnFirebaseDataChangeListener(OnFirebaseDataChangeListener onFirebaseDataChangeListener) {
        this.onFirebaseDataChangeListener = onFirebaseDataChangeListener;
    }
}

