package com.example.a300cemassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.content.Intent;
import android.view.View;
import android.widget.Button;

public class MainPage extends AppCompatActivity {

    private Button BuildingView;
    private Button WeatherView;

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

        WeatherView = (Button) findViewById(R.id.navNotes);
        WeatherView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDisplayWeather();
            }
        });

    }

    public void openHomePage() {
        Intent intent = new Intent(this, HomePage.class);
        startActivity(intent);

    }


    public void openDisplayWeather(){
        Intent intent = new Intent(this, DisplayWeather.class);
        startActivity(intent);
    }
}
