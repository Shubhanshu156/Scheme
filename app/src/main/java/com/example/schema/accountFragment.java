package com.example.schema;

import android.content.SharedPreferences;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;

public class accountFragment extends Fragment {
    private static final String TAG = "hihi";
    TabLayout tablayout;
    ViewPager2 vieapageer2;
    FragmentAdapter2 adapter;
    View rootview;
    private boolean shouldRefreshOnResume = false;
    void someMethod(){
        try{
            Log.d(TAG, "someMethod: "+"error found");
        TextView head=(TextView) rootview.findViewById(R.id.dpname);
        ImageView dp=(ImageView) rootview.findViewById(R.id.userdp);
        SharedPreferences shrd= getContext().getSharedPreferences("details",getActivity().MODE_PRIVATE);
        String ans=shrd.getString("currentuser", "");
        String val=ans+"g";
        String gender=shrd.getString(val,"no");
        Log.d(TAG, "gender of"+ans+gender);

        head.setText(ans);
        Log.d(TAG, "gender is: gender is"+gender);
        Log.d(TAG, "onCreateView: ans is"+ans);
        switch (gender){
            case "male":
                Log.d(TAG, "onCreateView: gen" + gender);
                Log.d(TAG, "onCreateView: "+"why this is not setting image");
                dp.setImageResource(R.drawable.male);
                break;
            case "female":
                Log.d(TAG, "onCreateView: gen"+gender);
                dp.setImageResource(R.drawable.female);
                break;
            default:
                Log.d(TAG, "onCreateView: gender is"+gender);
                dp.setImageResource(R.drawable.pp);

        }}
        finally {
            Log.d(TAG, "someMethod: "+"error found");
        }


    }

    @Override
    public void onResume() {
        super.onResume();
        // Check should we need to refresh the fragment
        if(shouldRefreshOnResume){
            // refresh fragment
            accountFragment ac=new accountFragment();
            getFragmentManager().beginTransaction().replace(R.id.fragment_conatiner,ac).commit();

        }
    }
    @Override
    public void onStop() {
        super.onStop();
        shouldRefreshOnResume = true;
    }

    @Override
    public View onCreateView( LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {
         rootview=inflater.inflate(R.layout.fragment_account,container,false);
        tablayout=rootview.findViewById(R.id.tab_layout2);
        vieapageer2=rootview.findViewById(R.id.view_pager22);
        FragmentManager fm=getFragmentManager();
        adapter =new FragmentAdapter2(fm,getLifecycle());
        vieapageer2.setAdapter(adapter);
        tablayout.addTab(tablayout.newTab().setText("Saved"));
        tablayout.addTab(tablayout.newTab().setText("Setting"));
        tablayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                vieapageer2.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        vieapageer2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                tablayout.selectTab(tablayout.getTabAt(position));
            }
        });
        TextView head=(TextView) rootview.findViewById(R.id.dpname);
        ImageView dp=(ImageView) rootview.findViewById(R.id.userdp);
        SharedPreferences shrd= getContext().getSharedPreferences("details",getActivity().MODE_PRIVATE);
        String ans=shrd.getString("currentuser", "");
        String val=ans+"g";
        String gender=shrd.getString(val,"no");
        Log.d(TAG, "gender of"+ans+gender);

        head.setText(ans);
        Log.d(TAG, "gender is: gender is"+gender);
        Log.d(TAG, "onCreateView: ans is"+ans);
        switch (gender){
            case "male":
                Log.d(TAG, "onCreateView: gen" + gender);
                Log.d(TAG, "onCreateView: "+"why this is not setting image");
                dp.setImageResource(R.drawable.male);
                break;
            case "female":
                Log.d(TAG, "onCreateView: gen"+gender);
                dp.setImageResource(R.drawable.female);
                break;
            default:
                Log.d(TAG, "onCreateView: gender is"+gender);
                dp.setImageResource(R.drawable.pp);

        }

        return rootview;
    }
}
