package com.example.gradetrackerapp.model.db;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.gradetrackerapp.model.AssignmentLog;
import com.example.gradetrackerapp.model.CategoryLog;
import com.example.gradetrackerapp.model.CourseLog;
import com.example.gradetrackerapp.model.EnrolledLog;
import com.example.gradetrackerapp.model.GradeLog;
import com.example.gradetrackerapp.model.UserLog;

@Database(entities = {UserLog.class, CourseLog.class, AssignmentLog.class, GradeLog.class,
        CategoryLog.class, EnrolledLog.class}, version = 4)
public abstract class AppDatabase extends RoomDatabase {
    public static final String DB_NAME = "GRADETRACKER_DATABASE";
    public static final String USER_TABLE = "USERLOG_CLASS";
    public static final String COURSE_TABLE = "COURSELOG_CLASS";
    public static final String ASSIGNMENT_TABLE = "ASSIGNMENTLOG_CLASS";
    public static final String GRADE_TABLE = "GRADELOG_CLASS";
    public static final String CATEGORY_TABLE = "CATEGORYLOG_CLASS";
    public static final String ENROLLED_TABLE = "ENROLLEDLOG_CLASS";

    public abstract GradeTrackerDAO getGradeTrackerDAO();
}
