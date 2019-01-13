package tw.noel.sung.com.demo_firebasesolution.util.firebase.analytics;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.StringDef;
import android.webkit.JavascriptInterface;

import com.google.firebase.analytics.FirebaseAnalytics;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import tw.noel.sung.com.demo_firebasesolution.util.application.FirebaseSolutionApplication;


/**
 * Created by noel on 2018/5/26.
 */

public class MyFirebaseEventCenter {


    public static final String VIEW_MAIN = "首頁";

    @StringDef(VIEW_MAIN)
    @Retention(RetentionPolicy.SOURCE)
    public @interface FirebaseView {
    }


    public static final String ACTION_MAIN_START = "開始使用";
    public static final String ACTION_MAIN_MENU_OPEN = "側邊攔 - 開啟";
    public static final String ACTION_MAIN_MENU_CLOSE = "側邊攔 - 關閉";

    public static final String ACTION_MAIN_TALK_BOARD_SEND = "聊天室 - 發送訊息";
    public static final String ACTION_MAIN_TALK_BOARD_REGISTER = "聊天室 - 註冊";



    @StringDef({ACTION_MAIN_START, ACTION_MAIN_MENU_OPEN,
            ACTION_MAIN_MENU_CLOSE,ACTION_MAIN_TALK_BOARD_SEND,ACTION_MAIN_TALK_BOARD_REGISTER
    })
    @Retention(RetentionPolicy.SOURCE)
    public @interface FirebaseEvent {
    }


    public static final String CLASS_MAIN = "MainActivity";

    @StringDef(CLASS_MAIN)
    @Retention(RetentionPolicy.SOURCE)
    public @interface FirebaseClass {
    }


    private FirebaseAnalytics firebaseAnalytics;
    private Context context;

    public MyFirebaseEventCenter(Context context) {
        this.context = context;
        initFirebase();
    }
    //----------------

    /***
     *  firebase 初始化
     */
    private void initFirebase() {
        firebaseAnalytics = FirebaseSolutionApplication.firebaseAnalytics;
    }
    //----------------

    /***
     * 發送事件
     * @param viewName 畫面名稱
     * @param className class名稱
     * @param event 事件名稱
     */
    @JavascriptInterface
    public void sentEvent(@FirebaseView String viewName, @FirebaseClass String className, @FirebaseEvent String event) {
        Bundle bundle = new Bundle();
        bundle.putString("Class名稱", className);
        bundle.putString("事件名稱", event);
        firebaseAnalytics.logEvent(viewName, bundle);
    }
}
