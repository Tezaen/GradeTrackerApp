package com.example.gradetrackerapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.gradetrackerapp.model.AssignmentLog;
import com.example.gradetrackerapp.model.CourseItem;
import com.example.gradetrackerapp.model.CourseItemAdapter;
import com.example.gradetrackerapp.model.CourseLog;
import com.example.gradetrackerapp.model.db.AppDatabase;
import com.example.gradetrackerapp.model.db.GradeTrackerDAO;

import java.util.ArrayList;
import java.util.List;

public class CoursesMain extends AppCompatActivity {
        private Button AddButton, backBtn;
        private RecyclerView mRecyclerView;
        private CourseItemAdapter mCourseItemAdapter;
        private RecyclerView.LayoutManager mLayoutManager;
        private ArrayList<CourseItem> mCourseItems = new ArrayList<>();
        private int UserId;
        GradeTrackerDAO mDao;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_courses_main);
            AddButton = findViewById(R.id.Addbutton5);
            backBtn = findViewById(R.id.courseMainToMain);
            UserId = getIntent().getIntExtra(Menu.TAG,-1);
            mDao = AppDatabase.getInstance(getApplicationContext()).getGradeTrackerDAO();
            CreateItemList();
            RecyclerViewBuild();

            backBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(CoursesMain.this, Menu.class);
                    intent.putExtra(Menu.TAG, UserId);
                    startActivity(intent);
                }
            });

            AddButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(CoursesMain.this, AddCourse.class);
                    intent.putExtra(Menu.TAG, UserId);
                    startActivity(intent);
                }
            });
    }

    private void CreateItemList(){
        List<CourseLog> courses = mDao.getCoursesByUserID(UserId);
        for(CourseLog c : courses){
            mCourseItems.add(new CourseItem(c.getCourseName(), c.getInstructor()));
        }
    }

    private void RecyclerViewBuild(){
        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mCourseItemAdapter = new CourseItemAdapter(mCourseItems);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mCourseItemAdapter);


        mCourseItemAdapter.setOnItemClickListener(new CourseItemAdapter.OnItemClickedListener() {
            @Override
            public void onEditClick(int position) {
                CourseLog CourseId = mDao.getCourseByName(mCourseItems.get(position).getCourseName(), UserId);
                Intent intent = new Intent(CoursesMain.this, EditCourse.class);
                intent.putExtra("id", CourseId.getCourseId());
                intent.putExtra(Menu.TAG, UserId);
                startActivity(intent);
            }

            @Override
            public void onDelete(int position) {
                CourseLog deleteCourse = mDao.getCourseByName( mCourseItems.get(position).getCourseName(), UserId);
                List<AssignmentLog> log = mDao.getAssignmentByCourseName(deleteCourse.getCourseName(), UserId);
                for(AssignmentLog l : log){
                    mDao.delete(l);
                }
                mDao.delete(deleteCourse);
                mCourseItems.remove(position);
                mCourseItemAdapter.notifyItemRemoved(position);
            }
        });
    }
}