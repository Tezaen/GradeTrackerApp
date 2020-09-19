package com.example.gradetrackerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Menu extends AppCompatActivity {
    public static final String TAG = "MENU";
    private Button Cbutton;
    private Button button2;
    private Button button3;
    private int UserId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        UserId = getIntent().getIntExtra(TAG,-1);
        Cbutton = findViewById(R.id.Cbutton);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);

        /**
         * link to course page when clicked
         */
        Cbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Menu.this, CoursesMain.class);
                intent.putExtra(TAG, UserId);
                startActivity(intent);
            }
        });
        /**
         * link to assignment page when clicked
         */
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Menu.this, AssignmentMain.class);
                intent.putExtra(TAG, UserId);
                startActivity(intent);
            }
        });
        /**
         * link to grades page when clicked
         */
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Menu.this, GradesMain.class);
                intent.putExtra(TAG, UserId);
                startActivity(intent);
            }
        });
    }


    /**
     * Intent Factory to arrive at this page
     * @param c
     * @param userId
     * @return
     */
    public static Intent newIntent(Context c, int userId) {
        Intent intent = new Intent(c, Menu.class);
        intent.putExtra(TAG, userId);
        return intent;
    }
}