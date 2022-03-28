package com.example.layousexample.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.layousexample.model.User

@Dao
interface UserDao {
    @Query("SELECT * FROM user")
    fun getAll(): List<User>

    @Insert
    fun insert(user: User): Long
}