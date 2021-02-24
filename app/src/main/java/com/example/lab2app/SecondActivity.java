package com.example.lab2app;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    //Part 1

    TextView textView2;

    ImageView moon;
    ImageView waterfall;

    private int imageID;

    Intent i = getIntent();



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

////For part one
//
//        String s = i.getExtras().getString("testString");
//
//        textView2 = findViewById(R.id.textSecond);
//
//        textView2.setText(s);


        moon = findViewById(R.id.moon);
       moon.setOnClickListener(new View.OnClickListener(){
           @Override
           public void onClick(View v) {
               imageID = R.drawable.supermoon;

               moon.setId(imageID);

               finish();

           }
       });

       waterfall = findViewById(R.id.waterfall);
       waterfall.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               imageID = R.drawable.waterfall;

               waterfall.setId((imageID));

               finish();




           }
       });




    }

    @Override
    public void finish() {
        Intent intent = new Intent();
        intent.putExtra("imageId ", imageID);
        super.finish();
    }
}
