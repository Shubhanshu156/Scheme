package com.example.schema;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.service.autofill.FieldClassification;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButtonToggleGroup;

import java.nio.channels.InterruptedByTimeoutException;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class signin extends AppCompatActivity {
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signin);
        EditText eusername=(EditText) findViewById(R.id.username);
        EditText epasswords=(EditText) findViewById(R.id.password);
        EditText eemail=(EditText) findViewById(R.id.email);
        Button btn=(Button) findViewById(R.id.signin);
        Button btn2=(Button) findViewById(R.id.login);
        Intent intent=new Intent(this,login.class);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(intent);
                signin.this.finish();
            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Pattern p = Pattern.compile("[^\\p{L}+]");
                Matcher un = p.matcher(eusername.getText().toString());
                Matcher up = p.matcher(epasswords.getText().toString());
                Matcher ue = p.matcher(eemail.getText().toString());
                String TAG ="error";
                Log.d(TAG, "onClick: "+eusername.getText().toString());

                if(un.find()||eusername.getText().toString().matches("")||epasswords.getText().toString().matches("")||eemail.getText().toString().matches("")){
                    Toast.makeText(signin.this, "Enter valid inputs",
                            Toast.LENGTH_LONG).show();
                }
                //do whatever you want when input has digits/ special characters/ white space
                else{
                    //valid string
                    String username=eusername.getText().toString();
                    String passwords=epasswords.getText().toString();
                    String email=eemail.getText().toString();

                    SharedPreferences shrd=getSharedPreferences("details", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor=shrd.edit();
                    Set<String> names=new HashSet<String>();
                    Set<String> usernames=shrd.getStringSet("usernames",names);
                    usernames.add(username);
                    editor.putStringSet("usernames",usernames);

                    editor.putString(username+"p",passwords);
                    editor.putString(username+"e",email);
                    editor.putString("currentuser",username);
                    editor.commit();
                    Log.d(TAG, "onClick: "+username+usernames+passwords);
                    Toast.makeText(signin.this, "Account Created Successfully!!",
                            Toast.LENGTH_LONG).show();
                    Intent intent2=new Intent(signin.this,MainActivity.class);
                    startActivity(intent2);
                    signin.this.finish();
                }


            }
        });

}}
