package com.example.a300cemassignment;

//Import Statements for all imported interfaces in this class
import android.os.Bundle;
import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class signup extends AppCompatActivity {

    //Private Statements used for User Signup when they signup on the app
    private EditText userID;
    private EditText usernameSignup;
    private EditText passwordSignup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        //These Variables are where the data gets entered and pulled from
        userID = (EditText) findViewById(R.id.userID);
        usernameSignup = (EditText) findViewById(R.id.usernameSignup);
        passwordSignup = (EditText) findViewById(R.id.passwordSignup);
    }
    //Method to convert the input to a string which will then be passed to the
    //database ready to be stored.
    public void save(View v){
        int anuserID = Integer.parseInt(userID.getText().toString());
        String aUsername = usernameSignup.getText().toString();
        String aPassword = passwordSignup.getText().toString();
        UserDatabase db = new UserDatabase(this);
        db.addUser(new Users(anuserID, aUsername, aPassword));
    }


}




