package com.inferno.projectx;

import android.app.Application;

import io.realm.Realm;

/**
 * Created by saravana.subramanian on 8/21/17.
 */

public class AppController extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Realm.init(this);

    }


    @Override
    public void onTerminate() {
        super.onTerminate();
    }
}
