package com.example.gradetrackerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.gradetrackerapp.model.AssignmentLog;
import com.example.gradetrackerapp.model.CourseLog;
import com.example.gradetrackerapp.model.db.AppDatabase;
import com.example.gradetrackerapp.model.db.GradeTrackerDAO;

import java.util.List;

public class EditCourse extends AppCompatActivity {

        private Button btn;
        private EditText cName;
        private EditText profName;
        private int UserId;
        private int Id;
        GradeTrackerDAO mDao;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_edit_course);
            mDao = AppDatabase.getInstance(getApplicationContext()).getGradeTrackerDAO();
            btn = findViewById(R.id.button7);
            cName = findViewById(R.id.editTextTextPersonName3);
            profName = findViewById(R.id.editTextTextPersonName4);
            UserId = getIntent().getIntExtra(Menu.TAG,-1);
            Id = getIntent().getIntExtra("id", -1);
            CourseLog log = mDao.getCourseById(Id);
            CourseLog newLog = mDao.getCourseById(Id);
            cName.setText(log.getCourseName());
            profName.setText(log.getInstructor());
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    CourseLog log2 = mDao.getCourseByName(cName.getText().toString(), UserId);
                    newLog.setInstructor(profName.getText().toString());
                    newLog.setCourseName(cName.getText().toString());
                    //checks if the user did not change the course name
                    if(log.getCourseName().equals(newLog.getCourseName())){
                        mDao.update(log);
                        Intent intent = new Intent(EditCourse.this,CoursesMain.class);
                        intent.putExtra(Menu.TAG, UserId);
                        startActivity(intent);
                    }else{
                        //User changes course name
                        if(log2 == null){
                            List<AssignmentLog> updateAssignments = mDao.getAssignmentByCourseName(log.getCourseName(),UserId);
                            for(AssignmentLog a : updateAssignments){
                                a.setCourseName(newLog.getCourseName());
                                mDao.update(a);
                            }
                            mDao.update(newLog);
                            Intent intent = new Intent(EditCourse.this, CoursesMain.class);
                            intent.putExtra(Menu.TAG, UserId);
                            startActivity(intent);
                        } else{
                            Toast.makeText(getApplicationContext(),"Course name already exist", Toast.LENGTH_LONG).show();
                        }
                    }
                }
            });

    }
}