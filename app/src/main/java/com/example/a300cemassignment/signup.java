package com.example.a300cemassignment;

import android.os.Bundle;
import android.content.Intent;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.EditText;

public class signup extends AppCompatActivity {

    private EditText userID;
    private EditText usernameSignup;
    private EditText passwordSignup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        userID = (EditText) findViewById(R.id.userID);
        usernameSignup = (EditText) findViewById(R.id.usernameSignup);
        passwordSignup = (EditText) findViewById(R.id.passwordSignup);
    }

    public void save(View v){
        int anuserID = Integer.parseInt(userID.getText().toString());
        String aUsername = usernameSignup.getText().toString();
        String aPassword = passwordSignup.getText().toString();
        UserDatabase db = new UserDatabase(this);
        db.addUser(new Users(anuserID, aUsername, aPassword));
    }


}




