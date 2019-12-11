package com.example.a300cemassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.content.Intent;
import android.view.View;
import android.widget.Button;

public class MainPage extends AppCompatActivity {

    private Button BuildingView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);

        BuildingView = (Button) findViewById(R.id.navBuilding);
        BuildingView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openHomePage();
            }
        });
    }

    public void openHomePage() {
        Intent intent = new Intent(this, HomePage.class);
        startActivity(intent);


    }
}
