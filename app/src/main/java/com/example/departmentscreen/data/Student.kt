package com.example.departmentscreen.data

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "students",
    foreignKeys = [
        ForeignKey(
            entity = Department::class,
            parentColumns = ["departmentId"],
            childColumns = ["departmentId"],
            onDelete = ForeignKey.CASCADE
        )
    ],
    indices = [Index(value = ["departmentId"])]
)
data class Student(
    @PrimaryKey(autoGenerate = true)
    val studentId: Long = 0,
    val studentName: String,
    val departmentId: Long
)
