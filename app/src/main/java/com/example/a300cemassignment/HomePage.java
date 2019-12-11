package com.example.a300cemassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class HomePage extends AppCompatActivity {
    //
    private ListView UniLoc;
    private String[] UniBuildings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        //
        UniBuildings = getResources().getStringArray(R.array.UniBuildings);
        UniLoc = (ListView) findViewById(R.id.buildingList);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, UniBuildings);
        UniLoc.setAdapter(arrayAdapter);
        //
        UniLoc.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                intent.putExtra("name",UniBuildings[i]);
                startActivity(intent);


            }
        });

    }





}





