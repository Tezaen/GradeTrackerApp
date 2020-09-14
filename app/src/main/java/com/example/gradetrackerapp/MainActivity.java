package com.example.gradetrackerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button loginBtn, createBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        wiredUp();

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent loginIntent = new Intent(MainActivity.this, Login.class);
                startActivity(loginIntent);
            }
        });

        createBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent createAccountIntent = new Intent(MainActivity.this, CreateAccount.class);
                startActivity(createAccountIntent);
            }
        });
    }

    private void wiredUp() {
        loginBtn = findViewById(R.id.loginBtn);
        createBtn = findViewById(R.id.createAccBtn);
    }
}