package com.example.gradetrackerapp;

import android.content.Context;

import androidx.room.Room;
import androidx.test.core.app.ApplicationProvider;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.example.gradetrackerapp.model.CourseLog;
import com.example.gradetrackerapp.model.db.AppDatabase;
import com.example.gradetrackerapp.model.db.GradeTrackerDAO;

import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class CourseTest {
    private AppDatabase db;
    private GradeTrackerDAO mDao;
    private Context context;
    private CourseLog testCourse;

    /**
     * Set up DB and add a test user
     */
    @Before
    public void setUpDB() {
        context = ApplicationProvider.getApplicationContext();
        db = Room.inMemoryDatabaseBuilder(context, AppDatabase.class).build();
        mDao = db.getGradeTrackerDAO();
    }
    //test
    /**
     * Close DB after test run
     */
    @After
    public void closeDB() {
        db.close();
    }
}
