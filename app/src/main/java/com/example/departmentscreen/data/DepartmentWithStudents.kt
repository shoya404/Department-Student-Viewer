package com.example.departmentscreen.data

import androidx.room.Embedded
import androidx.room.Relation

data class DepartmentWithStudents(
    @Embedded
    val department: Department,

    @Relation(
        parentColumn = "departmentId",
        entityColumn = "departmentId"
    )
    val students: List<Student>
)
