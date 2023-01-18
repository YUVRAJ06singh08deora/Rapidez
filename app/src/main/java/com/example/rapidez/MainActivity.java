package com.example.rapidez;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {
    FirebaseDatabase firebaseDatabase;
    DatabaseReference speedref;
private TextView clickbtn,mapbtn,location,speedtxt;
LinearLayout lastLocation,performance,history;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DatabaseReference reference= FirebaseDatabase.getInstance().getReference().child("newRequest");
        firebaseDatabase = FirebaseDatabase.getInstance();
        lastLocation=findViewById(R.id.lastlocation);
        performance=findViewById(R.id.performance);
        history=findViewById(R.id.history);
        speedtxt=findViewById(R.id.speed_txt);
        speedref=firebaseDatabase.getReference("V");
        getSpeed();
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

    private void getSpeed() {
        speedref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                // this method is call to get the realtime
                // updates in the data.
                // this method is called when the data is
                // changed in our Firebase console.
                // below line is for getting the data from
                // snapshot of our database.
                float value = snapshot.getValue(float.class);
                String value1=Float.toString(value);

                // after getting the value we are setting
                // our value to our text view in below line.
                speedtxt.setText(value1);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // calling on cancelled method when we receive
                // any error or we are not able to get the data.
                Toast.makeText(MainActivity.this, "Fail to get data.", Toast.LENGTH_SHORT).show();
            }
        });
    }
}