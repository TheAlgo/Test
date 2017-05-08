package com.example.android.implicitintent;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP_MR1)
    public void dosomething(View view) {
        switch(view.getId())
        {
            case R.id.button: {
                Intent i1 = new Intent(Intent.ACTION_VIEW, Uri.parse("http://vtop.vit.ac.in"));
                startActivity(i1);
                break;
            }
            case R.id.button2:
            {
                Intent i2=new Intent(Intent.ACTION_VIEW,Uri.parse("tel:8961707536"));
                startActivity(i2);
                break;
            }
            case R.id.button3:
            {
                String [] recipient={"dhirajjain0@gmail.com"};
                Intent emailIntent=new Intent(Intent.ACTION_SEND);
                emailIntent.putExtra(Intent.EXTRA_EMAIL,recipient);
                emailIntent.putExtra(Intent.EXTRA_SUBJECT,"suggestions");
                emailIntent.setType("text/html");
                startActivity(Intent.createChooser(emailIntent,"choose an email app"));

            }
                break;
            }

        }
    }
