package com.example.gradetrackerapp.model.db;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.gradetrackerapp.model.AssignmentLog;
import com.example.gradetrackerapp.model.CourseLog;
import com.example.gradetrackerapp.model.UserLog;

@Database(entities = {UserLog.class, CourseLog.class, AssignmentLog.class}, version = 7,exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    public static final String DB_NAME = "GRADETRACKER_DATABASE";
    public static final String USER_TABLE = "USERLOG_CLASS";
    public static final String COURSE_TABLE = "COURSELOG_CLASS";
    public static final String ASSIGNMENT_TABLE = "ASSIGNMENTLOG_CLASS";
    private static AppDatabase instance;


    public abstract GradeTrackerDAO getGradeTrackerDAO();

    public static synchronized AppDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    AppDatabase.class, DB_NAME)
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .build();
        }
        return instance;
    }
}
