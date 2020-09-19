package com.example.gradetrackerapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.gradetrackerapp.model.UserLog;
import com.example.gradetrackerapp.model.db.AppDatabase;
import com.example.gradetrackerapp.model.db.GradeTrackerDAO;

public class Login extends AppCompatActivity {
    // input texts and login button initiation
    EditText username;
    EditText password;
    Button mButton1;
    UserLog mUser;
    GradeTrackerDAO mDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getDb();
        /**
         * adding input text and login button into initiated variables
         */

        username = findViewById(R.id.usernameTxt);
        password = findViewById(R.id.passwordTxt);
        mButton1 = findViewById(R.id.button1);

         /** set listener to login button
         * test to see if this works
         *when clicked will check if account exists
         */
        mButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                username.setTextColor(Color.BLACK);
                password.setTextColor(Color.BLACK);
                String un = username.getText().toString();
                String pw = password.getText().toString();

                if (checkCredentials(un, pw)) {
                    Intent intent = Menu.newIntent(Login.this, mUser.getUserId());
                    startActivity(intent);
                }
            }
        });
    }


    public static Intent newIntent(Context context) {
        Intent intent = new Intent(context, Login.class);
        return intent;
    }

    /**
     * Builds the Room DB for DAO
     */

    private void getDb() {
        mDao = Room.databaseBuilder(this, AppDatabase.class, AppDatabase.DB_NAME)
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build()
                .getGradeTrackerDAO();
    }

    /**
     * method that checks if password/username is correct
     * @param un
     * @param pw
     * @return
     */
    public boolean checkCredentials(String un, String pw) {
        boolean validUn = checkValidUsername(un);
        boolean validPw = checkValidPassword(pw);

        toastMaker(validUn, validPw);

        return validPw && validUn;
    }

    /**
     * Specifically checks if username exist
     * @param un
     * @return
     */
    private boolean checkValidUsername(String un) {
        mUser = mDao.getUserByUsername(un);

        return mUser != null;
    }

    /**
     * Specifically check if password is associated with username given
     * @param pw
     * @return
     */
    private boolean checkValidPassword(String pw) {
        if (mUser != null) {
            return mUser.getPassword().equals(pw);
        }
        return false;
    }

    /**
     * pop up toast according to what correct/incorrect inputs were made
     * @param bool_un
     * @param bool_pw
     */
    private void toastMaker(boolean bool_un, boolean bool_pw) {
        if (bool_un && bool_pw) {
            Toast.makeText(this, "Log In Successful", Toast.LENGTH_LONG).show();

        } else if (!bool_un && !bool_pw) {
            Toast.makeText(this, "Username & Password are incorrect", Toast.LENGTH_LONG).show();
            username.setTextColor(Color.RED);
            password.setTextColor(Color.RED);

        } else if (!bool_un) {
            Toast.makeText(this, "Username is incorrect", Toast.LENGTH_LONG).show();
            username.setTextColor(Color.RED);

        } else {
            Toast.makeText(this, "Password is incorrect", Toast.LENGTH_LONG).show();
            password.setTextColor(Color.RED);
        }
    }
}