package com.assignment_6_2.appConfig.util;

import android.app.Application;
import android.content.Context;

/**
 * Created by Phinda Encore Tomson on 4/19/2016.
 */
public class App extends Application {
    private static Context context;
    private static App singleton;

    public App getSingleton(){
        if(singleton==null){
            singleton=new App();
        }
        return App.singleton;
    }
    public void onCreate() {
        super.onCreate();
        App.context = getApplicationContext();
        singleton = this;
    }
    public static Context getContext(){
        return App.context;
    }
}
