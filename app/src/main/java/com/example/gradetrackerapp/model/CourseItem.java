package com.example.gradetrackerapp.model;

public class CourseItem {
    String courseName;
    String professorName;

    public CourseItem(String courseName, String professorName) {
        this.courseName = courseName;
        this.professorName = professorName;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getProfessorName() {
        return professorName;
    }

    public void setProfessorName(String professorName) {
        this.professorName = professorName;
    }
}
