package com.example.schema;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class DiscoverFragment extends Fragment {

    private static final String TAG ="error" ;
    RecyclerView discoverrecyclerview;
    DiscoverAdapter
            parentItemAdapter
            = new DiscoverAdapter(
            ChildItemList());
    List<ChildItem> ChilItemList;
    @Override
    public View onCreateView( LayoutInflater inflater, ViewGroup container,  Bundle savedInstanceState) {
        View rootview=inflater.inflate(R.layout.fragment_discover,container,false);
        EditText filter=rootview.findViewById(R.id.filter);

        ChilItemList=ChildItemList();
        discoverrecyclerview
                = rootview.findViewById(
                R.id.discover_recyclerview);
        LinearLayoutManager
                layoutManager
                = new LinearLayoutManager(
                getActivity());


        discoverrecyclerview
                .setAdapter(parentItemAdapter);
        discoverrecyclerview
                .setLayoutManager(layoutManager);

        filter.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                List<ChildItem> templst=new ArrayList<ChildItem>();
                String ans=toUpperCase(s);
                String lower=ans.toLowerCase();
                String upper=ans.toUpperCase();
                for (ChildItem item:ChilItemList){
                    if (item.getChildItemTitle().contains(lower)||item.getChildItemTitle().contains(upper)){
                        templst.add(item);
                    }
                }

                ChilItemList=templst;
                parentItemAdapter.updateList(ChilItemList);
                ChilItemList=ChildItemList();
                parentItemAdapter.notifyDataSetChanged();
            }
            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        return rootview;
    }


    public static String toUpperCase(CharSequence string) {
        char upperCaseChars[] = new char[string.length()];

        for (int i = 0; i < string.length(); i++) {
            upperCaseChars[i] = Character.toUpperCase(string.charAt(i));
        }

        return new String(upperCaseChars);
    }

    private List<ChildItem> ChildItemList()
    {
        Data d=new Data();
        List<ChildItem> ChildItemList
                = d.getAlList();



        return ChildItemList;
    }
}
