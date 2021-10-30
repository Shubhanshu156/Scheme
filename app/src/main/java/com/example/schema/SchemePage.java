package com.example.schema;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager2.widget.ViewPager2;

//import com.example.schema.navigation.homefragment.FragmentAdapter;
import com.google.android.material.tabs.TabLayout;

import java.util.HashSet;
import java.util.Set;


public class SchemePage extends AppCompatActivity {

    private static final String TAG ="hi" ;
    TabLayout tabLayout;
    ViewPager2 Pager2;
    FragmentAdapter adapter;


    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SharedPreferences sharedPreferences = getSharedPreferences("details",MODE_PRIVATE);
        SharedPreferences.Editor myEdit = sharedPreferences.edit();
        String username=sharedPreferences.getString("currentuser","nouser");
        Toast.makeText(SchemePage.this, username, Toast.LENGTH_SHORT).show();
        setContentView(R.layout.scheme_page);
        tabLayout=findViewById(R.id.tab_layout);
        Pager2=(ViewPager2) findViewById(R.id.view_pager2);
        FragmentManager fm=getSupportFragmentManager();
        Intent intent=getIntent();
        int id=intent.getIntExtra("imageid",0);
        String Schemename=intent.getStringExtra("name");
        String application=intent.getStringExtra("application");
        String information=intent.getStringExtra("information");
        ImageView schemeprofile=findViewById(R.id.scheme_profile);
        schemeprofile.setImageResource(id);
        TextView title=findViewById(R.id.scheme_name);
        title.setText(Schemename);
        CheckBox favbtn=(CheckBox) findViewById(R.id.favorite);
        Set<String> empty=new HashSet<String>();
        String f=username+"f";
        Set<String> fav= new HashSet<>();
        fav = sharedPreferences.getStringSet(f,empty);

        if (fav.contains(Schemename)){
            Log.d(TAG, "onCreate: "+"checkedis");
            favbtn.setChecked(true);
        }
        Log.d(TAG, "favourate is: "+fav);
        Set<String> finalFav = fav;
        favbtn.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView,boolean isChecked) {
                if (isChecked){
                    SharedPreferences sharedPreferences = getSharedPreferences("details",MODE_PRIVATE);

                    SharedPreferences.Editor myEdit = sharedPreferences.edit();


                    finalFav.add(Schemename);
                    Log.d(TAG, "Scheme name is: "+Schemename);
                    myEdit.putStringSet(f, finalFav);
                    myEdit.apply();

                    Log.d(TAG, "onCheckedChanged: "+ finalFav);
                    Toast.makeText(getApplicationContext(), ""+sharedPreferences.getStringSet(f,empty), Toast.LENGTH_SHORT).show();


               }
                else{
                    finalFav.remove(Schemename);
                    myEdit.putStringSet(f, finalFav);
                    myEdit.apply();
                    Toast.makeText(getApplicationContext(), "remove from favourate", Toast.LENGTH_SHORT).show();
                }

            }
            }
        );

//        Log.d(TAG, "onCreatehello: "+application);

        adapter =new FragmentAdapter(fm,getLifecycle(),information,application);
        Pager2.setAdapter(adapter);
        tabLayout.addTab(tabLayout.newTab().setText("INFORMATION"));
        tabLayout.addTab(tabLayout.newTab().setText("APPLICATION"));
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                Pager2.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        Pager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                tabLayout.selectTab(tabLayout.getTabAt(position));
            }
        });



    }
}
