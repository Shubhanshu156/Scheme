package com.example.schema;

import android.graphics.Typeface;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.StyleSpan;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

///**
// * A simple {@link Fragment} subclass.
// * Use the {@link InformationFragment#newInstance} factory method to
// * create an instance of this fragment.
// */
public class InformationFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private static final String TAG = "hi";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private String minformation;

    public InformationFragment(String information) {
        minformation = information;
        // Required empty public constructor
    }
//
//    /**
//     * Use this factory method to create a new instance of
//     * this fragment using the provided parameters.
//     *
//     * @param param1 Parameter 1.
//     * @param param2 Parameter 2.
//     * @return A new instance of fragment InformationFragment.
//     */
    // TODO: Rename and change types and number of parameters
//    public static InformationFragment newInstance(String param1, String param2) {
//        InformationFragment fragment = new InformationFragment();
//        Bundle args = new Bundle();
//        args.putString(ARG_PARAM1, param1);
//        args.putString(ARG_PARAM2, param2);
//        fragment.setArguments(args);
//        return fragment;
//    }

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
        View rootview = inflater.inflate(R.layout.fragment_information, container, false);
        TextView textView = rootview.findViewById(R.id.information);
        SpannableString ss = new SpannableString(minformation);
        StyleSpan boldSpan = new StyleSpan(Typeface.BOLD);
        int index =minformation.indexOf("PMJDY Benefits", 0);
        Log.d(TAG, "onCreateView: " + index);
        if (index != -1) {
//            ss.setSpan(boldSpan, 0, 12, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            ss.setSpan(boldSpan, index, index + 14, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            textView.setText(ss);
        } else {
            textView.setText(minformation);
        }
        return rootview;
    }
}
