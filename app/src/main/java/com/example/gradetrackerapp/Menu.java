package com.example.gradetrackerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Menu extends AppCompatActivity {
    public static final String TAG = "MENU";
    private Button Cbutton;
    private Button button2;
    private Button button3;
    private int UserId;
    TextView footer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        UserId = getIntent().getIntExtra(TAG,-1);
        Cbutton = findViewById(R.id.Cbutton);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        footer = findViewById(R.id.textViewFT2);

        Cbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Menu.this, CoursesMain.class);
                intent.putExtra(TAG, UserId);
                startActivity(intent);
            }
        });
        //link to assignment page
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Menu.this, AssignmentMain.class);
                intent.putExtra(TAG, UserId);
                startActivity(intent);
            }
        });
        //link to grades page
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Menu.this, GradesMain.class);
                intent.putExtra(TAG, UserId);
                startActivity(intent);
            }
        });
    }

    public static Intent newIntent(Context c, int userId) {
        Intent intent = new Intent(c, Menu.class);
        intent.putExtra(TAG, userId);
        return intent;
    }
}