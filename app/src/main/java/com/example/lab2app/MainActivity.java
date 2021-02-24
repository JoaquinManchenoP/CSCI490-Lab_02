package com.example.lab2app;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {


    public static final int REQUEST_CODE = 1;

    private Button button;
    private Intent i;
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.plain_text_input);

        button = findViewById(R.id.button);
        i = new Intent(this, SecondActivity.class);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = editText.getText().toString();
                i.putExtra("testString", s);
//                startActivity(i);
                startActivityForResult(i, REQUEST_CODE);


                Log.i("root", "Clicked");
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == REQUEST_CODE && resultCode == Activity.RESULT_OK){
            Bundle extras = data.getExtras();
            if(extras != null){

                int imageId = extras.getInt("imageID");
                Log.i("message", String.valueOf(imageId));
                ConstraintLayout currentLayout = findViewById(R.id.main_layout);
                currentLayout.setBackground(getDrawable(imageId));




            }
        }
    }
}