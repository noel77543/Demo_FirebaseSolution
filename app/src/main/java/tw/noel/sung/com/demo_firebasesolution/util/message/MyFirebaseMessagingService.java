package tw.noel.sung.com.demo_firebasesolution.util.message;


import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import java.util.Map;

/**
 * Created by noel on 2018/5/28.
 */

public class MyFirebaseMessagingService extends FirebaseMessagingService {

    /***
     *  firebase console  messaging自訂Key
     */
    private final String KEY_TITLE = "title";
    private final String KEY_CONTENT = "content";

    //-----------

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);

        Map<String, String> data = remoteMessage.getData();


    }

    //-------------

}
