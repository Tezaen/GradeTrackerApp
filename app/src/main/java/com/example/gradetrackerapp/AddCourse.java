package com.example.gradetrackerapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.gradetrackerapp.model.CourseLog;
import com.example.gradetrackerapp.model.db.AppDatabase;
import com.example.gradetrackerapp.model.db.GradeTrackerDAO;

public class AddCourse extends AppCompatActivity {
    private Button btn, backBtn;
    private EditText cName;
    private EditText profName;
    private int UserId;
    GradeTrackerDAO mDao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_course);
        mDao = AppDatabase.getInstance(getApplicationContext()).getGradeTrackerDAO();
        btn = findViewById(R.id.button6);
        backBtn = findViewById(R.id.addCourseBack);
        cName = findViewById(R.id.editTextTextPersonName);
        profName = findViewById(R.id.editTextTextPersonName2);
        UserId = getIntent().getIntExtra(Menu.TAG,-1);

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AddCourse.this, CoursesMain.class);
                intent.putExtra(Menu.TAG, UserId);
                startActivity(intent);
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //check to see if the editTexts are empty
                CourseLog log = mDao.getCourseByName(cName.getText().toString(), UserId);
                //checks to see that user can't enter a similar course name into the DB
                if(log == null){
                    CourseLog courseLog = new CourseLog(cName.getText().toString(), profName.getText().toString(), UserId);
                    mDao.insert(courseLog);
                    Intent intent = new Intent(AddCourse.this,CoursesMain.class);
                    intent.putExtra(Menu.TAG, UserId);
                    startActivity(intent);
                }else{
                    Toast.makeText(getApplicationContext(),"Course name already exist", Toast.LENGTH_LONG).show();
                }
            }
        });

    }

}