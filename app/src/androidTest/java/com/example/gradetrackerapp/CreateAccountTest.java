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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

@RunWith(AndroidJUnit4.class)
public class CreateAccountTest {

    private AppDatabase db;
    private GradeTrackerDAO mDao;
    private Context context;

    @Before
    public void setUpDB() {
        context = ApplicationProvider.getApplicationContext();
        db = Room.inMemoryDatabaseBuilder(context, AppDatabase.class).build();
        mDao = db.getGradeTrackerDAO();
    }

    @After
    public void closeDB() {
        db.close();
    }

    @Test
    public void verifyUserNameTest() {
        boolean pass = false;
        UserLog testUser = new UserLog("din_djarin", "baby_yoda_ftw");
        UserLog mUser = new UserLog("din_djarin", "baby_yoda_ftw");
        mDao.insert(mUser);
        UserLog dummyUser = mDao.getUserByUsername(testUser.getUsername());
        if (dummyUser != null) {
            pass = true;
        }
        assertTrue(pass);
    }

    @Test
    public void verifyUsernameFailsTest() {
        boolean pass = false;
        UserLog testUser = new UserLog("din_djarinNOTTT", "baby_yoda_ftw");
        UserLog mUser = new UserLog("din_djarin", "baby_yoda_ftw");
        mDao.insert(mUser);
        UserLog dummyUser = mDao.getUserByUsername(testUser.getUsername());
        if (dummyUser != null) {
            pass = true;
        }
        assertFalse(pass);
    }

    @Test
    public void verifyPasswordPassesTest() {
        String enteredPassword = "baby_yoda_ftw";
        UserLog mUser = new UserLog("din_djarin", "baby_yoda_ftw");
        mDao.insert(mUser);
        assertEquals(mUser.getPassword(), enteredPassword);
    }

    @Test
    public void verifyPasswordFailsTest() {
        String enteredPassword = "baeskar_4_ever";
        UserLog mUser = new UserLog("din_djarin", "baby_yoda_ftw");
        mDao.insert(mUser);
        assertNotEquals(mUser.getPassword(), enteredPassword);
    }
}
