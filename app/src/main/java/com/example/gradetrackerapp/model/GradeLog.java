package com.example.gradetrackerapp.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.example.gradetrackerapp.model.db.AppDatabase;

@Entity(tableName = AppDatabase.GRADE_TABLE)
public class GradeLog {
    @PrimaryKey(autoGenerate = true)
    private int mGradeId;

    private int mAssignmentId;
    private int mUserId;
    private int mCourseId;
    private String mDateEarned;
    private int mScore;

    public GradeLog(int mAssignmentId, int mUserId, int mCourseId, String mDateEarned, int mScore) {
        this.mAssignmentId = mAssignmentId;
        this.mUserId = mUserId;
        this.mCourseId = mCourseId;
        this.mDateEarned = mDateEarned;
        this.mScore = mScore;
    }

    public int getGradeId() {
        return mGradeId;
    }

    public void setGradeId(int mGradeId) {
        this.mGradeId = mGradeId;
    }

    public int getAssignmentId() {
        return mAssignmentId;
    }

    public void setAssignmentId(int mAssignmentId) {
        this.mAssignmentId = mAssignmentId;
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

    public String getDateEarned() {
        return mDateEarned;
    }

    public void setDateEarned(String mDateEarned) {
        this.mDateEarned = mDateEarned;
    }

    public int getScore() {
        return mScore;
    }

    public void setScore(int mScore) {
        this.mScore = mScore;
    }
}
