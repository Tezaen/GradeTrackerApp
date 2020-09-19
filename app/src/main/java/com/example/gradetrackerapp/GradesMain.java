package com.example.gradetrackerapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.gradetrackerapp.model.AssignmentLog;
import com.example.gradetrackerapp.model.CourseLog;
import com.example.gradetrackerapp.model.db.AppDatabase;
import com.example.gradetrackerapp.model.db.GradeTrackerDAO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GradesMain extends AppCompatActivity {
    private Button backBtn;
    private TextView gradesView;
    private int userId;
    private GradeTrackerDAO dao;
    private List<CourseLog> listOfCourses;
    private List<List<AssignmentLog> > listOfAssignmentsfromEachCourse;
    private HashMap<String, Integer> mapOfGrades = new HashMap<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grades_main);
        userId = getIntent().getIntExtra(Menu.TAG, -1);
        wired();
        getDb();
        calculateGrades();
        display();
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent backIntent = new Intent(GradesMain.this, Menu.class);
                backIntent.putExtra(Menu.TAG, userId);
                startActivity(backIntent);
            }
        });
    }

    private void wired() {
        backBtn = findViewById(R.id.gradesToMenu);
        gradesView = findViewById(R.id.gradesView);
    }

    private void getDb() {
        dao = Room.databaseBuilder(this, AppDatabase.class, AppDatabase.DB_NAME)
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build()
                .getGradeTrackerDAO();
    }

    private void calculateGrades() {
        List<AssignmentLog> courseAssignmentList;
        listOfCourses = dao.getCoursesByUserID(userId);
        for(CourseLog c: listOfCourses) {
            Log.d("Course HERE", String.valueOf(c));
            courseAssignmentList = dao.getAssignmentByCourseName(c.getCourseName(), userId);
            Log.d("Message", String.valueOf(courseAssignmentList));
            int sum = 0;
            int avg = 0;
            for(AssignmentLog a: courseAssignmentList) {
                sum += a.getAssignmentScore();
            }
            avg = sum / courseAssignmentList.size();
            Log.d("Avg", String.valueOf(avg));
            Log.d("CourseName HERE", String.valueOf(c.getCourseName()));
            mapOfGrades.put(c.getCourseName(), avg);
        }
    }

    private void display() {
        if(mapOfGrades.size() <= 0) {
            gradesView.setText("No Assignments inputted");
            return;
        }

        gradesView.setMovementMethod(new ScrollingMovementMethod());
        StringBuilder sb = new StringBuilder();
        for(Map.Entry<String, Integer> set: mapOfGrades.entrySet()) {
            sb.append("===============================\n");
            sb.append("Course: " + set.getKey() + ", Grade Average: " + set.getValue());
        }
        gradesView.setText(sb.toString());
    }
}