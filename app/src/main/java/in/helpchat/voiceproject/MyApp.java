package in.helpchat.voiceproject;

import android.app.Application;

/**
 * Created by gauravwadhwa on 16/06/16.
 */

public class MyApp extends Application {
    static MyApp instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }

    public static MyApp getInstance(){
        return instance;
    }


    public String getText(){
        return "app";
    }
}
