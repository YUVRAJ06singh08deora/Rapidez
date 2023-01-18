package com.example.rapidez;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
private TextView clickbtn,mapbtn,location;
LinearLayout lastLocation,performance,history;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lastLocation=findViewById(R.id.lastlocation);
        performance=findViewById(R.id.performance);
        history=findViewById(R.id.history);
       lastLocation.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent intent=new Intent(getApplicationContext(),LastlocationActivity.class);
               startActivity(intent);
           }
       });
        performance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),Driverss_performanceActivity.class);
                startActivity(intent);
            }
        });
        history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),LastlocationActivity.class);
                startActivity(intent);
            }
        });

    }
}