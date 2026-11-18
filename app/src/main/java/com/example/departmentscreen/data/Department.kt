package com.example.departmentscreen.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "departments")
data class Department(
    @PrimaryKey(autoGenerate = true)
    val departmentId: Long = 0,
    val departmentName: String
)
