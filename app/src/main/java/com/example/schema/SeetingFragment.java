package com.example.schema;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.provider.ContactsContract;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.HashSet;
import java.util.Set;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SeetingFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SeetingFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public SeetingFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SeetingFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SeetingFragment newInstance(String param1, String param2) {
        SeetingFragment fragment = new SeetingFragment();
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
        String TAG="HI";
        // Inflate the layout for this fragment
        View rootview=inflater.inflate(R.layout.fragment_seeting, container, false);
        EditText updatename=(EditText) rootview.findViewById(R.id.updatename);
        EditText updatemail=(EditText) rootview.findViewById(R.id.updatemail);
        EditText updatepassword=(EditText) rootview.findViewById(R.id.updatepassword);
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("details",getActivity().MODE_PRIVATE);

        SharedPreferences.Editor myEdit = sharedPreferences.edit();


        Button updaete=rootview.findViewById(R.id.update);
        Spinner dropdown = rootview.findViewById(R.id.spinner1);
//create a list of items for the spinner.
        String[] items = new String[]{"Select gender","male","female"};

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_dropdown_item, items);
//set the spinners adapter to the previously created one.
        dropdown.setAdapter(adapter);
        updaete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username=sharedPreferences.getString("currentuser","no");
                Set<String> empty=new HashSet<String>();
                Set<String> usernames=sharedPreferences.getStringSet("usernames",empty);

                String n=updatename.getText().toString();

                String m=updatemail.getText().toString();
                String p=updatepassword.getText().toString();
                String gender=dropdown.getSelectedItem().toString();
                if (!n.matches("")){
                    String oldpass=sharedPreferences.getString(username+"p","on");
                    String oldgender=sharedPreferences.getString(username+"g","Select value");
                    String oldmail=sharedPreferences.getString((username),"nomail");
                    Set<String> fav=sharedPreferences.getStringSet(username+"f",empty);
                    myEdit.putString("currentuser",n);
                    myEdit.putString(n+"p",oldpass);
                    myEdit.putStringSet(n+"f",fav);

                    usernames.add(n);
                    usernames.remove(username);
                    username=n;
                    myEdit.putStringSet("usernames",usernames);
                    myEdit.putString(username+"g",oldgender);


                }
                if (!m.matches("")){
//                    String username=sharedPreferences.getString("currentuser","no");
                    myEdit.putString(username+"e",m);}
                if (!p.matches("")){myEdit.putString(username+"p",p);}
                if (gender.matches("male")||gender.matches("female")){
                    String user=sharedPreferences.getString("currentuser","no");
                    String oldg=sharedPreferences.getString(user+"g","no");


                    myEdit.putString(username+"g",gender);

                }
                myEdit.apply();
                String g=sharedPreferences.getString(username+"g","no");
                Log.d(TAG, "now gender of: "+username+g);
                updatename.setText("");
                updatemail.setText("");
                updatepassword.setText("");
                dropdown.setSelection(0);
                Toast.makeText(getContext(), "Changes Saved", Toast.LENGTH_SHORT).show();
                accountFragment ac=new accountFragment();
                accountFragment parentFrag = ((accountFragment)SeetingFragment.this.getParentFragment());
                Log.d(TAG, "onClick: some error are found"+parentFrag);

//                parentFrag.someMethod();
                getFragmentManager().beginTransaction().replace(R.id.fragment_conatiner,ac).commit();
//                head.setText(n);
            }
        });
//        head.setText();



        return rootview;
    }
}