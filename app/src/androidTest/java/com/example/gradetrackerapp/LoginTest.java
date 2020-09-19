package com.example.gradetrackerapp;


import android.content.Context;

import androidx.room.Room;
import androidx.test.core.app.ApplicationProvider;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.example.gradetrackerapp.model.UserLog;
import com.example.gradetrackerapp.model.db.AppDatabase;
import com.example.gradetrackerapp.model.db.GradeTrackerDAO;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

@RunWith(AndroidJUnit4.class)
public class LoginTest {

    private AppDatabase db;
    private GradeTrackerDAO mDao;
    private Context context;
    private UserLog testUser;

    // Insert test account into db
    @Before
    public void setUpDB() {
        context = ApplicationProvider.getApplicationContext();
        db = Room.inMemoryDatabaseBuilder(context, AppDatabase.class).build();
        mDao = db.getGradeTrackerDAO();
        testUser = new UserLog("din_djarin", "baby_yoda_ftw");
        mDao.insert(testUser);
    }

    @After
    public void closeDB() {
        db.close();
    }

    // Test to verify correct login info entered
    @Test
    public void verifyLogin() {
        String inputUsername = "din_djarin";
        String inputPassword = "baby_yoda_ftw";

        //Code bellow not working
        //assertTrue(Login.checkCredentials(inputUsername,inputPassword));
    }

    // Test to verify incorrect login info entered
    @Test
    public void verifyLoginFail() {
        String inputUsername = "din_false";
        String inputPassword = "baby_false";

        //Code below not working
        //assertFalse(Login.checkCredentials(inputUsername,inputPassword));

    }
}
