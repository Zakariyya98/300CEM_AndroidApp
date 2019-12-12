package com.example.a300cemassignment;

//Import Statements for all imported interfaces in this class
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class HomePage extends AppCompatActivity {

    //There are the Private variables which will pull data to display the University Buildings
    private ListView UniLoc;
    private String[] UniBuildings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        //Create's an array of the items from the variable and places them into the ListView component
        UniBuildings = getResources().getStringArray(R.array.UniBuildings);
        UniLoc = (ListView) findViewById(R.id.buildingList);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, UniBuildings);
        UniLoc.setAdapter(arrayAdapter);

        //This is an intent which will load the activity
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





