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

    public AssignmentLog(String mAssignmentName, int mAssignmentMaxScore, int mAssignmentScore){
        this.mAssignmentName = mAssignmentName;
        this.mAssignmentMaxScore = mAssignmentMaxScore;
        this.mAssignmentScore = mAssignmentScore;
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
}
