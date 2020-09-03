package com.example.gradetrackerapp.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.example.gradetrackerapp.model.db.AppDatabase;

@Entity(tableName = AppDatabase.ASSIGNMENT_TABLE)
public class AssignmentLog {
    @PrimaryKey(autoGenerate = true)
    private int mAssignmentId;

    private String mAssignmentName;
    private int mAssignmentMaxScore;
    private int mAssignmentScore;
    private String mDetails;
    private String mAssignedDate;
    private int mCourseId;
    private String mDueDate;

    public AssignmentLog(String mAssignmentName, int mAssignmentMaxScore, int mAssignmentScore, String mDetails, String mAssignedDate, int mCourseId, String mDueDate) {
        this.mAssignmentName = mAssignmentName;
        this.mAssignmentMaxScore = mAssignmentMaxScore;
        this.mAssignmentScore = mAssignmentScore;
        this.mDetails = mDetails;
        this.mAssignedDate = mAssignedDate;
        this.mCourseId = mCourseId;
        this.mDueDate = mDueDate;
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

    public int getAssignmentMaxScore() {
        return mAssignmentMaxScore;
    }

    public void setAssignmentMaxScore(int mAssignmentMaxScore) {
        this.mAssignmentMaxScore = mAssignmentMaxScore;
    }

    public int getAssignmentScore() {
        return mAssignmentScore;
    }

    public void setAssignmentScore(int mAssignmentScore) {
        this.mAssignmentScore = mAssignmentScore;
    }

    public String getDetails() {
        return mDetails;
    }

    public void setDetails(String mDetails) {
        this.mDetails = mDetails;
    }

    public String getAssignedDate() {
        return mAssignedDate;
    }

    public void setAssignedDate(String mAssignedDate) {
        this.mAssignedDate = mAssignedDate;
    }

    public int getCourseId() {
        return mCourseId;
    }

    public void setCourseId(int mCourseId) {
        this.mCourseId = mCourseId;
    }

    public String getDueDate() {
        return mDueDate;
    }

    public void setDueDate(String mDueDate) {
        this.mDueDate = mDueDate;
    }
}
