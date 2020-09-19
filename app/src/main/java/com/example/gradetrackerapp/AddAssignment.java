package com.example.gradetrackerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.gradetrackerapp.model.AssignmentLog;
import com.example.gradetrackerapp.model.CourseLog;
import com.example.gradetrackerapp.model.db.AppDatabase;
import com.example.gradetrackerapp.model.db.GradeTrackerDAO;

public class AddAssignment extends AppCompatActivity {

    private Button btn, backBtn;
    private EditText assignmentName;
    private EditText courseName;
    private EditText grade;
    private int UserId;
    GradeTrackerDAO mDao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_assignment);
        mDao = AppDatabase.getInstance(getApplicationContext()).getGradeTrackerDAO();
        btn = findViewById(R.id.AddButton);
        backBtn = findViewById(R.id.addToAssignMain);
        assignmentName = findViewById(R.id.editTextAssignmentN);
        courseName = findViewById(R.id.editTextTextPersonName3);
        grade = findViewById(R.id.editTextGrade1);
        UserId = getIntent().getIntExtra(Menu.TAG,-1);

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AddAssignment.this, AssignmentMain.class);
                intent.putExtra(Menu.TAG, UserId);
                startActivity(intent);
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /**
                 * check to see if the editTexts are empty
                 */
                AssignmentLog log = mDao.getAssignmentByName(assignmentName.getText().toString(), UserId);
                CourseLog test = mDao.getCourseByNameAndId(courseName.getText().toString(), UserId);
                if(test != null){
                    if(log == null){
                        int container = 0;
                        try {
                            container = Integer.parseInt(grade.getText().toString());
                        }catch (NumberFormatException e){
                            Toast.makeText(getApplicationContext(),"Grade must be a number not a string", Toast.LENGTH_LONG).show();
                        }
                        AssignmentLog assignmentLog = new AssignmentLog(courseName.getText().toString(), assignmentName.getText().toString(), container, UserId);
                        mDao.insert(assignmentLog);
                        Intent intent = new Intent(AddAssignment.this, AssignmentMain.class);
                        intent.putExtra(Menu.TAG, UserId);
                        startActivity(intent);
                    }else{
                        Toast.makeText(getApplicationContext(),"Assignment already exist", Toast.LENGTH_LONG).show();
                    }
                }
                else{
                    Toast.makeText(getApplicationContext(),"Course name does not exist",Toast.LENGTH_LONG).show();
                }
            }
        });

    }
}