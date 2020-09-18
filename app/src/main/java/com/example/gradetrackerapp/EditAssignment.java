package com.example.gradetrackerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.gradetrackerapp.model.AssignmentLog;
import com.example.gradetrackerapp.model.db.AppDatabase;
import com.example.gradetrackerapp.model.db.GradeTrackerDAO;

public class EditAssignment extends AppCompatActivity {

    private Button btn, backBtn;
    private EditText assignmentName;
    private TextView courseName;
    private EditText grade;
    private int UserId;
    private int Id;
    private int courseId;
    GradeTrackerDAO mDao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_assignment);
        mDao = AppDatabase.getInstance(getApplicationContext()).getGradeTrackerDAO();
        btn = findViewById(R.id.EditButton);
        backBtn = findViewById(R.id.EditToAssignMain);
        assignmentName = findViewById(R.id.editTextAssignmentName);
        courseName = findViewById(R.id.editTextTextPersonName5);
        grade = findViewById(R.id.editTextGrade);
        UserId = getIntent().getIntExtra(Menu.TAG,-1);
        Id = getIntent().getIntExtra("id", -1);
        AssignmentLog log = mDao.getAssignmentById(Id);
        assignmentName.setText(log.getCourseName());
        courseName.setText(log.getCourseName());
        grade.setText(log.getAssignmentScore() + "");

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EditAssignment.this, AssignmentMain.class);
                intent.putExtra(Menu.TAG, UserId);
                startActivity(intent);
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AssignmentLog log2 = mDao.getAssignmentByName(assignmentName.getText().toString(), UserId);
                log.setCourseName(courseName.getText().toString());
                log.setAssignmentName(assignmentName.getText().toString());
                try {
                    int container = Integer.parseInt(grade.getText().toString());
                    log.setAssignmentScore(container);
                }catch (NumberFormatException e){
                    Toast.makeText(getApplicationContext(),"Grade must be a number not a string", Toast.LENGTH_LONG).show();
                }
                if(log.getAssignmentName().equals(assignmentName.getText().toString())){
                    mDao.update(log);
                    Intent intent = new Intent(EditAssignment.this, AssignmentMain.class);
                    intent.putExtra(Menu.TAG, UserId);
                    startActivity(intent);
                }else{
                    if(log2 == null){
                        mDao.update(log);
                        Intent intent = new Intent(EditAssignment.this, AssignmentMain.class);
                        intent.putExtra(Menu.TAG, UserId);
                        startActivity(intent);
                    } else{
                        Toast.makeText(getApplicationContext(),"Assignment already exist", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });


    }
}