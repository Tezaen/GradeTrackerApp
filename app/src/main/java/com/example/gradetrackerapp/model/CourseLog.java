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
    private String mDesc;
    private String mStartDate;
    private String mEndDate;

    public CourseLog(String courseName, String instructor, String desc, String startDate, String endDate, int mUserId){
        this.mCourseName = courseName;
        this.mInstructor = instructor;
        this.mDesc = desc;
        this.mStartDate = startDate;
        this.mEndDate = endDate;
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

    public String getDesc() {
        return mDesc;
    }

    public void setDesc(String mDesc) {
        this.mDesc = mDesc;
    }

    public String getStartDate() {
        return mStartDate;
    }

    public void setStartDate(String mStartDate) {
        this.mStartDate = mStartDate;
    }

    public String getEndDate() {
        return mEndDate;
    }

    public void setEndDate(String mEndDate) {
        this.mEndDate = mEndDate;
    }
}
