package com.example.schema;

import android.content.SharedPreferences;
import android.util.Log;

import java.util.HashSet;
import java.util.Set;

public class Application extends android.app.Application {
    private static final String TAG = "welcome";

    @Override
    public void onTerminate() {
        super.onTerminate();
        SharedPreferences shrd=getSharedPreferences("details",MODE_PRIVATE);
        Set<String> empty=new HashSet<String>();
        String user=shrd.getString("currentuser","no");
        Set<String> fav=shrd.getStringSet(user+"f",empty);
        Log.d(TAG, "onTerminate: "+fav);
    }
}
