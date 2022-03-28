package com.example.layousexample

import androidx.room.AutoMigration
import androidx.room.Database
import androidx.room.RenameColumn
import androidx.room.RoomDatabase
import androidx.room.migration.AutoMigrationSpec
import com.example.layousexample.dao.UserDao
import com.example.layousexample.model.User

@Database(
    entities = [User::class],
    version = 3,
//    autoMigrations = [
//        AutoMigration(
//            from = 2,
//            to = 3,
//            spec = AppDatabase.MyAutoMigration::class
//        )
//    ]
)
abstract class AppDatabase : RoomDatabase() {
//    @RenameColumn(tableName = "user", fromColumnName = "phone", toColumnName = "phone_number")
//    class MyAutoMigration : AutoMigrationSpec

    abstract fun userDao(): UserDao
}