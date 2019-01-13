package tw.noel.sung.com.demo_firebasesolution.util.application;

import android.app.Application;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class FirebaseSolutionApplication extends Application {
    public static FirebaseAnalytics firebaseAnalytics;
    public static DatabaseReference databaseReference;
    public static FirebaseAuth firebaseAuth;

    @Override
    public void onCreate() {
        super.onCreate();
        if (databaseReference == null) {
            databaseReference = FirebaseDatabase.getInstance().getReference();
        }
        if(firebaseAnalytics == null){
            firebaseAnalytics = FirebaseAnalytics.getInstance(getApplicationContext());
        }
        if(firebaseAuth == null){
            firebaseAuth = FirebaseAuth.getInstance();
        }
    }
}
