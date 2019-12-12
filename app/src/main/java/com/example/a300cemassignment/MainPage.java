package com.example.a300cemassignment;

//Import Statements for all imported interfaces in this class
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;

public class MainPage extends AppCompatActivity {
    //Private Variables for the Buttons
    private Button BuildingView;
    private Button WeatherView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);

        //Button to load the University Buildings activity
        BuildingView = (Button) findViewById(R.id.navBuilding);
        BuildingView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openHomePage();
            }
        });

        //Button to load the Activity with the Weather API
        WeatherView = (Button) findViewById(R.id.navNotes);
        WeatherView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDisplayWeather();
            }
        });

    }
    //Intent to start the Activity
    public void openHomePage() {
        Intent intent = new Intent(this, HomePage.class);
        startActivity(intent);

    }
    //Intent to start the Activity
    public void openDisplayWeather(){
        Intent intent = new Intent(this, DisplayWeather.class);
        startActivity(intent);
    }
}
