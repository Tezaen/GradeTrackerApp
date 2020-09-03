package com.example.gradetrackerapp.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.example.gradetrackerapp.model.db.AppDatabase;

//This class is Grade Category
@Entity(tableName = AppDatabase.CATEGORY_TABLE)
public class CategoryLog {
    @PrimaryKey(autoGenerate = true)
    private int mCategoryId;

    private String mTitle;
    private int mWeight;
    private int mGradeId;
    private int mAssignedDate;

    public CategoryLog(String mTitle, int mWeight, int mGradeId, int mAssignedDate) {
        this.mTitle = mTitle;
        this.mWeight = mWeight;
        this.mGradeId = mGradeId;
        this.mAssignedDate = mAssignedDate;
    }

    public int getCategoryId() {
        return mCategoryId;
    }

    public void setCategoryId(int mCategoryId) {
        this.mCategoryId = mCategoryId;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public int getWeight() {
        return mWeight;
    }

    public void setWeight(int mWeight) {
        this.mWeight = mWeight;
    }

    public int getGradeId() {
        return mGradeId;
    }

    public void setGradeId(int mGradeId) {
        this.mGradeId = mGradeId;
    }

    public int getAssignedDate() {
        return mAssignedDate;
    }

    public void setAssignedDate(int mAssignedDate) {
        this.mAssignedDate = mAssignedDate;
    }
}
