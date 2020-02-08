package com.example.myapplication5;

import android.app.Application;

import com.example.myapplication5.data.Datamanager;

import org.xutils.x;

public class UniteApp extends Application {
    @Override
    public void onCreate() {

        super.onCreate();
        x.Ext.init(this);
        Datamanager.intiDB(this);
    }
}
