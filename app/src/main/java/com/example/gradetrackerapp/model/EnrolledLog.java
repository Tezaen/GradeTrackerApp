package com.example.gradetrackerapp.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.example.gradetrackerapp.model.db.AppDatabase;

@Entity(tableName = AppDatabase.ENROLLED_TABLE)
public class EnrolledLog {
    @PrimaryKey(autoGenerate = true)
    private int mEnrolledId;

    private int mUserId;
    private int mCourseId;
    private String mEnrollmentDate;

    public EnrolledLog(int mUserId, int mCourseId, String mEnrollmentDate) {
        this.mUserId = mUserId;
        this.mCourseId = mCourseId;
        this.mEnrollmentDate = mEnrollmentDate;
    }

    public int getEnrolledId() {
        return mEnrolledId;
    }

    public void setEnrolledId(int mEnrolledId) {
        this.mEnrolledId = mEnrolledId;
    }

    public int getUserId() {
        return mUserId;
    }

    public void setUserId(int mUserId) {
        this.mUserId = mUserId;
    }

    public int getCourseId() {
        return mCourseId;
    }

    public void setCourseId(int mCourseId) {
        this.mCourseId = mCourseId;
    }

    public String getEnrollmentDate() {
        return mEnrollmentDate;
    }

    public void setEnrollmentDate(String mEnrollmentDate) {
        this.mEnrollmentDate = mEnrollmentDate;
    }
}
