package com.example.schema;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.HashSet;
import java.util.Set;

public class login extends AppCompatActivity {
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        String TAG="id are";
        Button login=(Button) findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText loginname=(EditText) findViewById(R.id.login_username);
                EditText loginpassword=(EditText) findViewById(R.id.login_password);
                String user=loginname.getText().toString();
                String pass=loginpassword.getText().toString();
                Log.d(TAG, "onClick: "+user+pass);
                SharedPreferences shrd=getSharedPreferences("details", Context.MODE_PRIVATE);
                SharedPreferences.Editor edit=shrd.edit();
                Set<String> empty=new HashSet<String>();
                Set<String> usernames=shrd.getStringSet("usernames",empty);
                String correctuser;
                String correctpassword;
                Log.d(TAG, "onClick: "+user);
                if (usernames.contains(user)){
                    correctuser=user;
                    Log.d(TAG, "onClick: "+"user found");
                    correctpassword=shrd.getString(user+"p","nouserfound");
                    if (pass.matches(correctpassword)){
                        Log.d(TAG, "onClick: "+"i am in second case");
                        edit.putString("currentuser",correctuser);
                        edit.commit();
                        Set<String> empty2=new HashSet<String>();
                        Log.d(TAG, "onClick: favoraute "+shrd.getStringSet(correctuser+"f", empty2));
                        Intent intent2=new Intent(login.this,MainActivity.class);
                        startActivity(intent2);
                    }
                    else{
                        Log.d(TAG, "onClick: "+"i am in 3 case");
                        Toast.makeText(login.this, "Wrong Password!!",
                                Toast.LENGTH_LONG).show();
                    }


                }
                else{
                    Toast.makeText(login.this, "NO Such user found!!",
                            Toast.LENGTH_LONG).show();
                }
            }
        });

    }
}
