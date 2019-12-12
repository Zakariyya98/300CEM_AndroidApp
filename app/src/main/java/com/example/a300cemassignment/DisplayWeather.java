package com.example.a300cemassignment;

//Import Statements for all imported interfaces in this class
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONArray;
import java.text.SimpleDateFormat;
import java.util.Calendar;

//This Class contains the code for the API OpenWeatherMap
//the API allows the user to see a real time view of how
//the weather is outside before they set off.

public class DisplayWeather extends AppCompatActivity {
    //These are the TextView Variables used for this API
    TextView Temp, Date, City, Type;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_weather);

        //Variables which will be used when using JSON Objects
        Temp = (TextView)findViewById(R.id.textTemp);
        Date = (TextView)findViewById(R.id.textDate);
        City = (TextView)findViewById(R.id.textCity);
        Type = (TextView)findViewById(R.id.textType);

        find_weather();
    }
    //This method allows the Variables to be manipulated and have their values changed
    //it also contains the OpenWeatherMap API as you can see from the String url.
    public void find_weather() {
        String url = "https://api.openweathermap.org/data/2.5/weather?q=Coventry,uk&appid=8b20a0b7c06840086cdf6681d821587e&units=Imperial";

        //This is where the API calls objects from the JSON File via the API  and passes them
        //into the strings where they will be displayed on the Activity Layout.
        JsonObjectRequest jor = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try{
                    JSONObject main_object = response.getJSONObject("main");
                    JSONArray array = response.getJSONArray("weather");
                    JSONObject object = array.getJSONObject(0);
                    String temp = String.valueOf(main_object.getDouble("temp"));
                    String type = object.getString("description");
                    String city = response.getString("name");

                    Type.setText(type);
                    City.setText(city);

                    Calendar calendar = Calendar.getInstance();
                    SimpleDateFormat sdf = new SimpleDateFormat("EEEE-MM-dd");
                    String formatted_date = sdf.format(calendar.getTime());

                    Date.setText(formatted_date);

                    double temp_int = Double.parseDouble(temp);
                    double centi = (temp_int - 32) / 1.8000;
                    centi = Math.round(centi);
                    int i = (int)centi;

                    Temp.setText(String.valueOf(i));


                }
                catch(JSONException e)
                {
                    e.printStackTrace();
                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }
        );

        RequestQueue queue = Volley.newRequestQueue(this);
        queue.add(jor);
    }

}
