package com.example.schema;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;


public class ApplicationFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private static final String TAG = "wwelcome";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private String mapplication;

    public ApplicationFragment(String application) {
        // Required empty public constructor
        this.mapplication=application;
//        Log.d(TAG, "ApplicationFragment: "+mapplication);
    }


    // TODO: Rename and change types and number of parameters


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
        View rootview=inflater.inflate(R.layout.fragment_application, container, false);
        TextView textView=rootview.findViewById(R.id.application);
//        txt.setMovementMethod(LinkMovementMethod.getInstance());
//        Log.d(TAG, "onCreateView: "+mapplication);
        SpannableString spannable = new SpannableString(mapplication);
        StyleSpan boldSpan = new StyleSpan(Typeface.BOLD);
        int index =mapplication.indexOf("Website", 0);
        int index2=mapplication.indexOf("Eligibility",0);
        int index3=mapplication.indexOf("Document required",0);
        if (index>0) {
            spannable.setSpan(new ForegroundColorSpan(Color.BLACK), index, index + 7, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        }if (index2>0) {

            spannable.setSpan(new ForegroundColorSpan(Color.BLACK), index2, index2 + 11, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        } if (index3>0) {
            spannable.setSpan(new ForegroundColorSpan(Color.BLACK), index3, index3 + 17, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        }textView.setText(spannable);


        return rootview;
    }
}