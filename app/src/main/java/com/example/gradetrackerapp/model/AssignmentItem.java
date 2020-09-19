package com.example.gradetrackerapp.model;

public class AssignmentItem {
    private String CourseName;
    private String AssignmentName;
    private int Grade;

    public AssignmentItem(String courseName, String assignmentName, int grade) {
        this.CourseName = courseName;
        this.AssignmentName = assignmentName;
        this.Grade = grade;
    }

    public String getCourseName() {
        return CourseName;
    }

    public void setCourseName(String courseName) {
        this.CourseName = courseName;
    }

    public String getAssignmentName() {
        return AssignmentName;
    }

    public void setAssignmentName(String assignmentName) {
        this.AssignmentName = assignmentName;
    }

    public int getGrade() {
        return Grade;
    }

    public void setGrade(int grade) {
        this.Grade = grade;
    }
}
