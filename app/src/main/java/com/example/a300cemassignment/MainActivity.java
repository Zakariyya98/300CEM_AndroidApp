package com.example.a300cemassignment;

//Import Statements for all imported interfaces in this class
import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.Camera;
import android.hardware.biometrics.BiometricPrompt;
import android.os.Build;
import android.os.Bundle;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.os.CancellationSignal;
import android.provider.MediaStore;
import android.view.Menu;
import android.view.MenuItem;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class MainActivity extends AppCompatActivity {

    //These are the private variables used to initiate taking a picture with the camera.
    private ImageView UserImage;
    private static final int REQUEST_IMAGE_CAPTURE = 101;

    //Private variables for the buttons on this Class.
    private Button buttonSignup;
    private Button buttonHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Setting the Variable to the Button ID.
        UserImage = findViewById(R.id.ViewPicture);

        //Button to open the Signup Page
        buttonSignup = (Button) findViewById(R.id.registerButton);
        buttonSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                opensignup();
            }
        });

        //Button to open the homepage needs login verification first
        buttonHome = (Button) findViewById(R.id.buttonLogin);
        buttonHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMainPage();
            }
        });

        //Biometric Fingerprint Scanning, my phone does Iris and Face Unlock too
        final Executor executor = Executors.newSingleThreadExecutor();
        final BiometricPrompt biometricPrompt = new BiometricPrompt.Builder(this)
                .setTitle("Authentication via Fingerprint")
                .setSubtitle("Please Place finger on Scanner")
                .setDescription("Samsung Devices from S8 Onwards have alternative Authentication Options Iris and Face Scanning")
                .setNegativeButton("Cancel", executor, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {

                    }
                }).build();

        Button authenticate = findViewById(R.id.AuthFingerprint);
        final MainActivity activity = this;

        authenticate.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.P)
            @Override
            public void onClick(View v) {

                biometricPrompt.authenticate(new CancellationSignal(), executor, new BiometricPrompt.AuthenticationCallback() {
                    @Override
                    public void onAuthenticationSucceeded(BiometricPrompt.AuthenticationResult result) {


                        activity.runOnUiThread(new Runnable() {
                            @Override
                            public void run() {

                                Toast.makeText(MainActivity.this, "User Authorised", Toast.LENGTH_LONG).show();
                            }
                        });
                    }
                });
            }
        });
    }
    //The Intent which is used to initiate the activity to take a picture.
    public void takePicture(View view)
    {
        Intent imageTakeintent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if(imageTakeintent.resolveActivity(getPackageManager())!=null);
        {
            startActivityForResult(imageTakeintent,REQUEST_IMAGE_CAPTURE);
        }

    }

    //This code allows the Image to be shown on screen as a Bitmap as Data.
    @Override
    protected void onActivityResult(int requestcode, int resultcode, Intent data) {
        super.onActivityResult(requestcode, resultcode, data);
        {
            if (requestcode == REQUEST_IMAGE_CAPTURE && resultcode == RESULT_OK) ;
        }
        Bundle extras = data.getExtras();
        Bitmap imagebitmap = (Bitmap) extras.get("data");
        UserImage.setImageBitmap(imagebitmap);
    }

    //Used to open the Signup Class.
    public void opensignup() {
        Intent intent = new Intent(this, signup.class);
        startActivity(intent);
    }

    //Used to open the MainPage Class.
    public void openMainPage() {
        Intent intent = new Intent(this, MainPage.class);
        startActivity(intent);
    }
}









