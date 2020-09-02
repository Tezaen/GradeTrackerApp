package com.example.gradetrackerapp.model.db;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.gradetrackerapp.model.CourseLog;
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
    UserLog getUserByUserId(int userId);

    //courses DAO
    @Insert
    void insert(CourseLog... courseLogs);

}
