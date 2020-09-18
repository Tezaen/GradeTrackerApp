package com.example.gradetrackerapp;

import android.content.Context;

import androidx.room.Room;
import androidx.test.core.app.ApplicationProvider;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.example.gradetrackerapp.model.AssignmentLog;
import com.example.gradetrackerapp.model.db.AppDatabase;
import com.example.gradetrackerapp.model.db.GradeTrackerDAO;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class AssignmentTest {
    private AppDatabase db;
    private GradeTrackerDAO mDao;
    private Context context;
    private AssignmentLog testAssignment;

    /**
     * Set up DB and add a test assignment
     */
    @Before
    public void setUpDB() {
        context = ApplicationProvider.getApplicationContext();
        db = Room.inMemoryDatabaseBuilder(context, AppDatabase.class).build();
        mDao = db.getGradeTrackerDAO();
        testAssignment = new AssignmentLog("MAT1", "HW1", 50, 1);
        mDao.insert(testAssignment);
    }

    /**
     * Close DB after test run
     */
    @After
    public void closeDB() {
        db.close();
    }

    @Test
    public void insertAssignmentTest() {
        AssignmentLog newAssignment = new AssignmentLog("ENG1", "Reading 1", 10, 1);
        mDao.insert(newAssignment);
        AssignmentLog inputted = mDao.getAssignmentByName("Reading 1", 1);
        Assert.assertEquals("ENG1", inputted.getCourseName());
        Assert.assertEquals("Reading 1", inputted.getAssignmentName());
        Assert.assertEquals(10, inputted.getAssignmentScore());
        Assert.assertEquals(1, inputted.getUserId());
    }

    @Test
    public void setAssignmentNameTest() {
        String input = "Reading 2";
        testAssignment.setAssignmentName(input);
        Assert.assertEquals(input, testAssignment.getAssignmentName());
    }

    @Test
    public void setCourseNameOfAssignmentTest() {
        String input = "Sci 1";
        testAssignment.setCourseName(input);
        Assert.assertEquals(input, testAssignment.getCourseName());
    }

    @Test
    public void setScoreTest() {
        int input = 30;
        testAssignment.setAssignmentScore(input);
        Assert.assertEquals(input, testAssignment.getAssignmentScore());
    }
}
