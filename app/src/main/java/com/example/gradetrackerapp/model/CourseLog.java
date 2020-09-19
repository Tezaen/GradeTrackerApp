package com.example.gradetrackerapp.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.example.gradetrackerapp.model.db.AppDatabase;

@Entity(tableName = AppDatabase.COURSE_TABLE)
public class CourseLog {
    @PrimaryKey(autoGenerate = true)
    private int mCourseId;
    private int mUserId;
    private String mCourseName;
    private String mInstructor;

    public CourseLog(String courseName, String instructor, int mUserId){
        this.mCourseName = courseName;
        this.mInstructor = instructor;
        this.mUserId = mUserId;
    }

    public int getUserId() {
        return mUserId;
    }

    public void setUserId(int userId) {
        mUserId = userId;
    }

    public int getCourseId() {
        return mCourseId;
    }

    public void setCourseId(int mCourseId) {
        this.mCourseId = mCourseId;
    }

    public String getCourseName() {
        return mCourseName;
    }

    public void setCourseName(String mCourseName) {
        this.mCourseName = mCourseName;
    }

    public String getInstructor() {
        return mInstructor;
    }

    public void setInstructor(String mInstructor) {
        this.mInstructor = mInstructor;
    }

}
