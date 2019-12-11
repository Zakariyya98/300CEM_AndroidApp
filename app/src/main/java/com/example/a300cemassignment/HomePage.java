package com.example.a300cemassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.widget.ArrayAdapter;
import android.widget.ListView;

public class HomePage extends AppCompatActivity {
    //ListView building1;
    //String buildings[] = {"Engineering,","HUB", "mfg", "Science", "Library", "sports"};

    private ListView UniLoc;
    private String[] UniBuildings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        //
        //building1 = (ListView)findViewById(R.id.buildingList);
        //ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, R.layout.activity_home_page, R.id.textView, buildings);
        //building1.setAdapter(arrayAdapter);

        UniBuildings = getResources().getStringArray(R.array.UniBuildings);

        UniLoc = (ListView) findViewById(R.id.buildingList);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, UniBuildings);
        UniLoc.setAdapter(arrayAdapter);
        //UniLoc.setOnItemClickListener();

               // new AdapterView.OnItemClickListener() {
                    //@Override
                    //public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        //Toast.makeText(getBaseContext(), candidateNames[position] + ", seriously?", Toast.LENGTH_SHORT).show();
                   // }
               // }
       // );
    }





}





