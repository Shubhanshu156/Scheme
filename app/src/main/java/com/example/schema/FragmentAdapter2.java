package com.example.schema;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

//import com.example.schema.navigation.homefragment.ApplicationFragment;

public class FragmentAdapter2 extends FragmentStateAdapter {
    private static final String TAG ="hi" ;

    public FragmentAdapter2(FragmentManager fragmentManager,  Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);

//        Log.d(TAG, "createFragment: "+application+" "+information);
    }

    @Override
    public Fragment createFragment(int position) {
//        Log.d(TAG, "createFragment: "+application+" "+information);
        switch (position){
            case 0:
                return new SavedFragment();


        }

        return new SeetingFragment();
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
