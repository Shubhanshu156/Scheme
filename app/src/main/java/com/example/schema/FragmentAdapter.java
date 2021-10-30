package com.example.schema;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

//import com.example.schema.navigation.homefragment.ApplicationFragment;

public class FragmentAdapter extends FragmentStateAdapter {
    private static final String TAG ="hi" ;
    private String information;
    private String application;
    public FragmentAdapter(FragmentManager fragmentManager,  Lifecycle lifecycle,String information,String application) {
        super(fragmentManager, lifecycle);
        this.information=information;
        this.application=application;
//        Log.d(TAG, "createFragment: "+application+" "+information);
    }

    @Override
    public Fragment createFragment(int position) {
//        Log.d(TAG, "createFragment: "+application+" "+information);
        switch (position){
            case 1:
                return new ApplicationFragment(application);

        }

        return new com.example.schema.InformationFragment(information);
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
