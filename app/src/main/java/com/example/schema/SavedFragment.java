package com.example.schema;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SavedFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SavedFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

    private List<ChildItem> ChildItemList;
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private static final String TAG = "welcome";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    public SavedFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SavedFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SavedFragment newInstance(String param1, String param2) {
        SavedFragment fragment = new SavedFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootview = inflater.inflate(R.layout.fragment_saved, container, false);
        ChildItemList=FavItemList();
        RecyclerView
                savedrecycler
                = rootview.findViewById(
                R.id.favrecycler);
        LinearLayoutManager
                layoutManager
                = new LinearLayoutManager(
                getActivity());
        SavedAdapter
                parentItemAdapter
                = new SavedAdapter(
                FavItemList());
        savedrecycler
                .setAdapter(parentItemAdapter);
        savedrecycler
                .setLayoutManager(layoutManager);
        savedrecycler.addOnItemTouchListener(
                new RecyclerItemClickListener(getContext(), savedrecycler ,new RecyclerItemClickListener.OnItemClickListener() {
                    @Override public void onItemClick(View view, int position) {
                        // do whatever
                        String msg=ChildItemList.get(position).getChildItemTitle();
                        Intent intent=new Intent(getContext(), com.example.schema.SchemePage.class);
                        intent.putExtra("imageid",ChildItemList.get(position).getImageid());
                        intent.putExtra("name",ChildItemList.get(position).getChildItemTitle());
                        intent.putExtra("information",ChildItemList.get(position).getInformation());
                        intent.putExtra("application",ChildItemList.get(position).getApplication());
                        intent.putExtra("back","yes");
                        getContext().startActivity(intent);
                        Toast.makeText(getContext(),msg,Toast.LENGTH_LONG).show(); Toast.makeText(getContext(),msg,Toast.LENGTH_LONG).show();
                    }

                    @Override public void onLongItemClick(View view, int position) {

                        // do whatever
                    }
                })
        );
        return rootview;
    }

    private List<ChildItem> FavItemList() {
        List<ChildItem> favlst= new ArrayList<ChildItem>();



        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("details",getActivity().MODE_PRIVATE);
        String uname=sharedPreferences.getString("currentuser","nouser");
        Toast.makeText(requireContext(), uname, Toast.LENGTH_SHORT).show();
        Data d=new Data();
        SharedPreferences.Editor myEdit = sharedPreferences.edit();
        Set<String> empty=new HashSet<String>();
        String f=uname+"f";
        Set<String> fav=sharedPreferences.getStringSet(f,empty);
        Toast.makeText(requireContext(), "favlist"+fav, Toast.LENGTH_SHORT).show();
        Log.d(TAG, "FavItemList: "+uname+fav);
        List<ChildItem> all=d.getAlList();
        for (ChildItem item:all){
//            ChildItem c=item;
            String n=item.getChildItemTitle();
            Log.d(TAG, "fav checking: "+n+fav);
            if (fav.contains(n)){
                Log.d(TAG, "fav passed: "+n+fav);
                favlst.add(item);
            }
        }
        Log.d(TAG, "FavItemList: "+fav+favlst);

return favlst;
    }
}