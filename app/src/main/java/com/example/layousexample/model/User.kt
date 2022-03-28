package com.example.layousexample.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class User(
    @PrimaryKey(autoGenerate = true) var uid: Long? = null,
    @ColumnInfo(name = "first_name") var firstName: String? = null,
    @ColumnInfo(name = "last_name") var lastName: String? = null,
    @ColumnInfo(name = "phone_number") var phoneNumber: String? = null
)