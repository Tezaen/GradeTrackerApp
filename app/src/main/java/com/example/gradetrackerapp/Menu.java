package com.example.gradetrackerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

public class Menu extends AppCompatActivity {
    public static final String TAG = "MENU";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    public static Intent newIntent(Context c, int userId) {
        Intent intent = new Intent(c, Menu.class);
        intent.putExtra(TAG, userId);
        return intent;
    }
}