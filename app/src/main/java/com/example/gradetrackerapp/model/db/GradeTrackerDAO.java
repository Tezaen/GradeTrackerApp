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

    //Grade DAO
    @Insert
    void insert(GradeLog... gradeLogs);

    @Update
    void update(GradeLog... gradeLogs);

    @Delete
    void delete(GradeLog gradeLog);

    @Query("select * from " + AppDatabase.GRADE_TABLE)
    List<GradeLog> getAllGrades();

    @Query("select * from " + AppDatabase.GRADE_TABLE + " where mGradeId = :gradeId")
    GradeLog getGradeById(int gradeId);

    @Query("select * from " + AppDatabase.GRADE_TABLE + " where mAssignmentId = :assignmentId")
    List<GradeLog> getGradesByAssignmentId(int assignmentId);

    //Category DAO
    @Insert
    void insert(CategoryLog... categoryLogs);

    @Update
    void update(CategoryLog... categoryLogs);

    @Delete
    void delete(CategoryLog categoryLog);

    @Query("select * from " + AppDatabase.CATEGORY_TABLE)
    List<CategoryLog> getAllCategories();

    @Query("select * from " + AppDatabase.CATEGORY_TABLE + " where mCategoryId = :categoryId")
    CategoryLog getCategoryById(int categoryId);

    //Enrolled DAO
    @Insert
    void insert(EnrolledLog... enrolledLogs);

    @Update
    void update(EnrolledLog... enrolledLogs);

    @Delete
    void delete(EnrolledLog enrolledLog);

    @Query("select * from " + AppDatabase.ENROLLED_TABLE)
    List<EnrolledLog> getAllEnrollment();


}
