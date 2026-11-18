package com.example.departmentscreen.data

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext

class DepartmentRepository(private val departmentDao: DepartmentDao) {

    val departmentsWithStudents: Flow<List<DepartmentWithStudents>> =
        departmentDao.getDepartmentsWithStudents()

    suspend fun seedInitialDataIfNeeded() {
        withContext(Dispatchers.IO) {
            if (departmentDao.getDepartmentCount() == 0) {
                val csId = departmentDao.insertDepartment(Department(departmentName = "Computer Science"))
                val eeId = departmentDao.insertDepartment(Department(departmentName = "Electrical Engineering"))
                val meId = departmentDao.insertDepartment(Department(departmentName = "Mechanical Engineering"))

                val sampleStudents = listOf(
                    Student(studentName = "Alice Smith", departmentId = csId),
                    Student(studentName = "Bob Jones", departmentId = csId),
                    Student(studentName = "Charlie Brown", departmentId = eeId),
                    Student(studentName = "Diana Prince", departmentId = eeId),
                    Student(studentName = "Evan Wright", departmentId = meId)
                )
                departmentDao.insertStudents(sampleStudents)
            }
        }
    }
}
