package com.example.gradetrackerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SuccessPage extends AppCompatActivity {

    boolean m1 =  true;
    private static final String M1ISTRUE = "com.example.gradetrackerapp";

    TextView mtextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_success_page);

        mtextView = findViewById(R.id.textView);
    }

    public static Intent newIntent(Context context, boolean m1) {
        Intent intent = new Intent(context, SuccessPage.class);
        intent.putExtra(M1ISTRUE,m1);
        return intent;
    }
}