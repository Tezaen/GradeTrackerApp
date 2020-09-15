package com.example.gradetrackerapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.gradetrackerapp.model.CourseItem;
import com.example.gradetrackerapp.model.CourseItemAdapter;
import com.example.gradetrackerapp.model.db.AppDatabase;
import com.example.gradetrackerapp.model.db.GradeTrackerDAO;

import java.util.ArrayList;
import java.util.List;

public class CoursesMain extends AppCompatActivity {
    private Button AddButton;
    private RecyclerView mRecyclerView;
    private CourseItemAdapter mCourseItemAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private ArrayList<CourseItem> mCourseItems = new ArrayList<>();
    GradeTrackerDAO mDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_courses_main);
        AddButton = findViewById(R.id.Addbutton5);

        AddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CoursesMain.this, AddCourse.class);
                startActivity(intent);
            }
        });
    }
    private void CreateItemList(){
        List<Courses> courses = mDao.getCourseByUserID();
    }
    private void getDb() {
        mDao = Room.databaseBuilder(this, AppDatabase.class, AppDatabase.DB_NAME)
                .allowMainThreadQueries()
                .build()
                .getGradeTrackerDAO();
    }
}