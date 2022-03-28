package com.example.layousexample.model

import com.google.gson.annotations.SerializedName

data class Todo(
    val completed: Boolean,
    val id: Int,
    @SerializedName("title")
    val name: String,
    val userId: Int
)
