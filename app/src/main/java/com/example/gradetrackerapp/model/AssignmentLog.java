package com.example.gradetrackerapp.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.example.gradetrackerapp.model.db.AppDatabase;

@Entity(tableName = AppDatabase.ASSIGNMENT_TABLE)
public class AssignmentLog {
    @PrimaryKey(autoGenerate = true)
    private int mAssignmentId;
    private int mUserId;
    private String mAssignmentName;
    private int mAssignmentScore;
    private String mCourseName;

    public AssignmentLog(String mCourseName, String mAssignmentName, int mAssignmentScore, int userId) {
        this.mAssignmentName = mAssignmentName;
        this.mAssignmentScore = mAssignmentScore;
        this.mCourseName = mCourseName;
        this.mUserId = userId;

    }

    public int getUserId() {
        return mUserId;
    }

    public void setUserId(int userId) {
        mUserId = userId;
    }

    public String getCourseName() {
        return mCourseName;
    }

    public void setCourseName(String courseName) {
        mCourseName = courseName;
    }

    public int getAssignmentId() {
        return mAssignmentId;
    }

    public void setAssignmentId(int mAssignmentId) {
        this.mAssignmentId = mAssignmentId;
    }

    public String getAssignmentName() {
        return mAssignmentName;
    }

    public void setAssignmentName(String mAssignmentName) {
        this.mAssignmentName = mAssignmentName;
    }

    public int getAssignmentScore() {
        return mAssignmentScore;
    }

    public void setAssignmentScore(int mAssignmentScore) {
        this.mAssignmentScore = mAssignmentScore;
    }

}
