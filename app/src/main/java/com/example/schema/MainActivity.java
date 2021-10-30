package com.example.schema;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.HashSet;
import java.util.Set;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "welcome";

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        homefragment home=new homefragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_conatiner,home).commit();

        BottomNavigationView bottomnav=(BottomNavigationView) findViewById(R.id.bottom_navigation);
        bottomnav.setOnNavigationItemSelectedListener(navlistner);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        return true;
    }
    private BottomNavigationView.OnNavigationItemSelectedListener navlistner=
            new BottomNavigationView.OnNavigationItemSelectedListener(){
                @Override
                public boolean onNavigationItemSelected( MenuItem item) {
                    Fragment selectedFragment=null;
                    switch (item.getItemId()){
                        case R.id.nav_home:
                            selectedFragment=new homefragment();
                            break;

                        case R.id.Discover:
                            selectedFragment=new DiscoverFragment();
                            break;

                        case R.id.Account:
                            selectedFragment=new accountFragment();
                            break;
                    }
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_conatiner,selectedFragment).commit();
                    return  true;
                }
            };

    @Override
    protected void onStop() {
        super.onStop();
        SharedPreferences shrd=getSharedPreferences("details",MODE_PRIVATE);
        SharedPreferences.Editor myedit=shrd.edit();
        Set<String> empty=new HashSet<String>();
        String user=shrd.getString("currentuser","no");
        Set<String> fav=shrd.getStringSet(user+"f",empty);
        myedit.putStringSet(user+"f",fav);
        myedit.commit();
        Log.d(TAG, "onTerminate: "+shrd.getStringSet(user+"f",empty));
    }
}
