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
public class UserTest {

    private AppDatabase db;
    private GradeTrackerDAO mDao;
    private Context context;
    private UserLog testUser;

    private static final String SET_USERNAME = "tester1";
    private static final String SET_PASSWORD = "woo123";

    private static final String FINAL_USERNAME = "forty40";
    private static final String FINAL_PASSWORD = "clockedout190";

    private static final String SET_FIRSTNAME = "Vince";
    private static final String SET_LASTNAME = "Brodey";

    private static final String FINAL_FIRSTNAME = "John";
    private static final String FINAL_LASTNAME = "Carter";

    /**
     * Set up DB and add a test user
     */
    @Before
    public void setUpDB() {
        context = ApplicationProvider.getApplicationContext();
        db = Room.inMemoryDatabaseBuilder(context, AppDatabase.class).build();
        mDao = db.getGradeTrackerDAO();
        testUser = new UserLog(SET_USERNAME, SET_PASSWORD);
        testUser.setFirstname(SET_FIRSTNAME);
        testUser.setLastname(SET_LASTNAME);
        mDao.insert(testUser);
    }

    @After
    public void closeDB() {
        db.close();
    }

    /**
     * Tests the User is in the DB
     */
    @Test
    public void getUserFromDBTest() {
        String input = "tester1";
        UserLog mUser = mDao.getUserByUsername(input);
        assertEquals(SET_USERNAME, mUser.getUsername());
        assertEquals(SET_PASSWORD, mUser.getPassword());
        assertEquals(SET_FIRSTNAME, mUser.getFirstname());
        assertEquals(SET_LASTNAME, mUser.getLastname());
    }

    /**
     * Tests the setUsername method
     */
    @Test
    public void setUsernameTest() {
        String input = "forty40";
        testUser.setUsername(input);
        assertEquals(FINAL_USERNAME, testUser.getUsername());
    }

    /**
     * Tests setPassword method
     */
    @Test
    public void setPasswordTest() {
        String input = "clockedout190";
        testUser.setPassword(input);
        assertEquals(FINAL_PASSWORD, testUser.getPassword());
    }

    /**
     * Tests setFirstName and setLastName
     */
    @Test
    public void setFirstNameandLastNameTest() {
        String firstName = "John";
        String lastName = "Carter";

        testUser.setFirstname(firstName);
        testUser.setLastname(lastName);

        assertEquals(FINAL_FIRSTNAME, testUser.getFirstname());
        assertEquals(FINAL_LASTNAME, testUser.getLastname());
    }

    /**
     * Test to see if username exists functionality works
     */
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

    /**
     * Test to see if username exists functionality fails
     */
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

    /**
     * Test to see if checking password functionality works
     */
    @Test
    public void verifyPasswordPassesTest() {
        String enteredPassword = "woo123";
        assertEquals(testUser.getPassword(), enteredPassword);
    }

    /**
     * Test to see if checking password functionality fails
     */
    @Test
    public void verifyPasswordFailsTest() {
        String enteredPassword = "baeskar_4_ever";
        assertNotEquals(testUser.getPassword(), enteredPassword);
    }
}
