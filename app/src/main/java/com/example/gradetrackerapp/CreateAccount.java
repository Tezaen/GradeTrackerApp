package com.example.gradetrackerapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.gradetrackerapp.model.UserLog;
import com.example.gradetrackerapp.model.db.AppDatabase;
import com.example.gradetrackerapp.model.db.GradeTrackerDAO;

public class CreateAccount extends AppCompatActivity {

    EditText usernameText, passwordText;
    Button createBtn, backBtn;
    GradeTrackerDAO mDao;
    UserLog newUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);
        wiredUp();
        getDb();

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent backIntent = new Intent(CreateAccount.this,
                        MainActivity.class);
                startActivity(backIntent);
            }
        });

        createBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String typedName = usernameText.getText().toString();
                String typedPassword = passwordText.getText().toString();
                if (checkValidUsername(typedName)) {
                    if (checkValidPW(typedPassword)) {
                        newUser = new UserLog(typedName, typedPassword);
                        mDao.insert(newUser);
                        Toast.makeText(CreateAccount.this, "Account has been created. Welcome!", Toast.LENGTH_SHORT).show();
                        Intent backIntent = new Intent(CreateAccount.this,
                                MainActivity.class);
                        startActivity(backIntent);
                    } else {
                        Toast.makeText(CreateAccount.this,
                                "Password not valid. Must be 3 or more letters", Toast.LENGTH_SHORT)
                                .show();
                    }
                } else {
                    Toast.makeText(CreateAccount.this, "This username has been taken",
                            Toast.LENGTH_SHORT)
                            .show();
                }
            }
        });
    }

    //Assigns the Text and Buttons
    private void wiredUp() {
        usernameText = findViewById(R.id.usernameTxt);
        passwordText = findViewById(R.id.passwordTxt);
        createBtn = findViewById(R.id.createAccBtn);
        backBtn = findViewById(R.id.backBtn);
    }

    //gives access to the DAO commands for querying
    private void getDb() {
        mDao = Room.databaseBuilder(this, AppDatabase.class, AppDatabase.DB_NAME)
                .allowMainThreadQueries()
                .build()
                .getGradeTrackerDAO();
    }

    //checks if username is valid/not taken
    private boolean checkValidUsername(String name) {
        if (mDao.getUserByUsername(name) == null) {
            return true;
        }
        return false;
    }

    //checks if password is valid
    private boolean checkValidPW(String pw) {
        if (pw.length() < 3) {
            return false;
        }
        return true;
    }
}