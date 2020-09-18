package com.example.gradetrackerapp;

import android.content.Context;

import androidx.room.Room;
import androidx.test.core.app.ApplicationProvider;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.example.gradetrackerapp.model.CourseLog;
import com.example.gradetrackerapp.model.db.AppDatabase;
import com.example.gradetrackerapp.model.db.GradeTrackerDAO;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class CourseTest {
    private AppDatabase db;
    private GradeTrackerDAO mDao;
    private Context context;
    private CourseLog testCourse;

    /**
     * Set up DB and add a test course
     */
    @Before
    public void setUpDB() {
        context = ApplicationProvider.getApplicationContext();
        db = Room.inMemoryDatabaseBuilder(context, AppDatabase.class).build();
        mDao = db.getGradeTrackerDAO();
        testCourse = new CourseLog("CS1", "Dr", 1);
        mDao.insert(testCourse);
    }

    /**
     * Close DB after test run
     */
    @After
    public void closeDB() {
        db.close();
    }

    @Test
    public void insertCourseTest() {
        CourseLog testCourse1 = new CourseLog("MAT1", "Dr", 1);
        mDao.insert(testCourse1);
        CourseLog mCourse = mDao.getCourseByNameAndId("MAT1", 1);
        Assert.assertEquals("MAT1", mCourse.getCourseName());
        Assert.assertEquals("Dr", mCourse.getInstructor());
        Assert.assertEquals(1, mCourse.getUserId());
    }

    /**
     * Tests the set function for course name
     */
    @Test
    public void setCourseNameTest() {
        String input = "ENG1";
        testCourse.setCourseName(input);
        Assert.assertEquals(input, testCourse.getCourseName());
    }

    /**
     * Tests the setting of the course instructor
     */
    @Test
    public void setCourseInstructor() {
        String input = "The CLINK";
        testCourse.setInstructor(input);
        Assert.assertEquals(input, testCourse.getInstructor());
    }
}
