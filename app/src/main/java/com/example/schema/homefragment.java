package com.example.schema;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;


import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class homefragment extends Fragment {
    private static final String TAG = "hi";
    View rootview;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,  Bundle savedInstanceState) {
        rootview=inflater.inflate(R.layout.fragment_home,container,false);



        RecyclerView
                ParentRecyclerViewItem
                = rootview.findViewById(
                R.id.parent_recyclerview);

        // Initialise the Linear layout manager
        LinearLayoutManager
                layoutManager
                = new LinearLayoutManager(
                getActivity());

        // Pass the arguments
        // to the parentItemAdapter.
        // These arguments are passed
        // using a method ParentItemList()
        com.example.schema.ParentItemAdapter
                parentItemAdapter
                = new com.example.schema.ParentItemAdapter(ParentItemList());

        // Set the layout manager
        // and adapter for items
        // of the parent recyclerview
        ParentRecyclerViewItem
                .setAdapter(parentItemAdapter);
        ParentRecyclerViewItem
                .setLayoutManager(layoutManager);
        return  rootview;
    }



    private List<com.example.schema.ParentItem> ParentItemList()
    {
        List<com.example.schema.ParentItem> itemList
                = new ArrayList<>();
        Data d=new Data();

//com.example.schema.ParentItem item= new com.example.schema.ParentItem("Schems for Studemts",ChildItemList());itemList.add(item);
        com.example.schema.ParentItem item1
                = new com.example.schema.ParentItem(
                "Schems for Women",
                d.getWomen());
        itemList.add(item1);
        com.example.schema.ParentItem item2
                = new com.example.schema.ParentItem(
                "Schems for Kissan",
                d.getKissan());
        itemList.add(item2);
        com.example.schema.ParentItem item3
                = new com.example.schema.ParentItem(
                "Schems for Employment",
                d.getEmployment());
        itemList.add(item3);
        com.example.schema.ParentItem item4
                = new com.example.schema.ParentItem(
                "PRADHAN MANTRI SCHEME",
                d.getPm());
        itemList.add(item4);
        com.example.schema.ParentItem item5
                = new com.example.schema.ParentItem(
                "Schems for Students",
                d.getWomen());
        itemList.add(item5);

        return itemList;
    }

    // Method to pass the arguments
    // for the elements
    // of child RecyclerView

}








