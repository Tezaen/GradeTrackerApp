package com.example.gradetrackerapp.model.db;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.gradetrackerapp.model.AssignmentLog;
import com.example.gradetrackerapp.model.CategoryLog;
import com.example.gradetrackerapp.model.CourseLog;
import com.example.gradetrackerapp.model.EnrolledLog;
import com.example.gradetrackerapp.model.GradeLog;
import com.example.gradetrackerapp.model.UserLog;

import java.util.List;

@Dao
public interface GradeTrackerDAO {
    //users DAO
    @Insert
    void insert(UserLog... userLogs);

    @Update
    void update(UserLog... userLogs);

    @Delete
    void delete(UserLog userLog);

    @Query("SELECT * FROM " + AppDatabase.USER_TABLE)
    List<UserLog> getAllUsers();

    @Query("SELECT * FROM " + AppDatabase.USER_TABLE + " WHERE mUsername = :username")
    UserLog getUserByUsername(String username);

    @Query("SELECT * FROM " + AppDatabase.USER_TABLE + " WHERE mUserId = :userId")
    UserLog getUserById(int userId);

    //courses DAO
    @Insert
    void insert(CourseLog... courseLogs);

    @Update
    void update(CourseLog... courseLogs);

    @Delete
    void delete(CourseLog courseLog);

    @Query("select * from " + AppDatabase.COURSE_TABLE)
    List<CourseLog> getAllCourses();

    @Query("select * from " + AppDatabase.COURSE_TABLE + " where mCourseId = :courseId")
    CourseLog getCourseById(int courseId);

    @Query("select * from " + AppDatabase.COURSE_TABLE + " where mCourseName = :name")
    CourseLog getCourseByName(String name);

    @Query("select * from " + AppDatabase.COURSE_TABLE + " where mUserId = :mUserId")
    List<CourseLog> getCourseByUserID(String mUserId);

    //assignment DAO
    @Insert
    void insert(AssignmentLog... assignmentLogs);

    @Update
    void update(AssignmentLog... assignmentLogs);

    @Delete
    void delete(AssignmentLog assignmentLog);

    @Query("select * from " + AppDatabase.ASSIGNMENT_TABLE)
    List<AssignmentLog> getAllAssignments();

    @Query("select * from " + AppDatabase.ASSIGNMENT_TABLE + " where mAssignmentId = :assignmentId")
    AssignmentLog getAssignmentById(int assignmentId);

    @Query("select * from " + AppDatabase.ASSIGNMENT_TABLE + " where mAssignmentName = :name")
    List<AssignmentLog> getAssignmentByName(String name);


}
