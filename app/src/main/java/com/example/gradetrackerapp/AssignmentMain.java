package com.example.gradetrackerapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Update;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.gradetrackerapp.model.AssignmentItem;
import com.example.gradetrackerapp.model.AssignmentItemAdapter;
import com.example.gradetrackerapp.model.AssignmentLog;
import com.example.gradetrackerapp.model.CourseItem;
import com.example.gradetrackerapp.model.CourseItemAdapter;
import com.example.gradetrackerapp.model.CourseLog;
import com.example.gradetrackerapp.model.db.AppDatabase;
import com.example.gradetrackerapp.model.db.GradeTrackerDAO;

import java.util.ArrayList;
import java.util.List;

public class AssignmentMain extends AppCompatActivity {

    private Button AddButton, backBtn;
    private RecyclerView mRecyclerView;
    private AssignmentItemAdapter mAssignmentItemAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private ArrayList<AssignmentItem> mAssignmentItems = new ArrayList<>();
    private int UserId;
    private int courseId;
    GradeTrackerDAO mDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assignment_main);
        AddButton = findViewById(R.id.AddAssignmentButton);
        backBtn = findViewById(R.id.assignMainToMain);
        UserId = getIntent().getIntExtra(Menu.TAG,-1);
        mDao = AppDatabase.getInstance(getApplicationContext()).getGradeTrackerDAO();
        CreateItemList();
        RecyclerViewBuild();
        AddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AssignmentMain.this, AddAssignment.class);
                intent.putExtra(Menu.TAG, UserId);
                startActivity(intent);
            }
        });
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AssignmentMain.this, Menu.class);
                intent.putExtra(Menu.TAG, UserId);
                startActivity(intent);
            }
        });
    }

    /**
     * Creates List of Assignments
     */
    private void CreateItemList(){
        List<AssignmentLog> assignmentLogs = mDao.getAssignmentByUser(UserId);
        for(AssignmentLog c : assignmentLogs){
            mAssignmentItems.add(new AssignmentItem(c.getCourseName(), c.getAssignmentName(), c.getAssignmentScore()));
        }
    }

    /**
     * Creates Recycler View
     */
    private void RecyclerViewBuild(){
        mRecyclerView = findViewById(R.id.recyclerView2);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mAssignmentItemAdapter = new AssignmentItemAdapter(mAssignmentItems);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAssignmentItemAdapter);


        mAssignmentItemAdapter.setOnItemClickListener(new AssignmentItemAdapter.OnItemClickedListener() {
            @Override
            public void onEditClick(int position) {
                AssignmentLog AssignmentId = mDao.getAssignmentByName(mAssignmentItems.get(position).getAssignmentName(), UserId);
                Intent intent = new Intent(AssignmentMain.this, EditAssignment.class);
                intent.putExtra("id", AssignmentId.getAssignmentId());
                intent.putExtra(Menu.TAG, UserId);
                startActivity(intent);
            }

            @Override
            public void onDelete(int position) {
                AssignmentLog deleteAssignment = mDao.getAssignmentByName( mAssignmentItems.get(position).getAssignmentName(), UserId);
                mDao.delete(deleteAssignment);
                mAssignmentItems.remove(position);
                mAssignmentItemAdapter.notifyItemRemoved(position);
            }
        });
    }
}