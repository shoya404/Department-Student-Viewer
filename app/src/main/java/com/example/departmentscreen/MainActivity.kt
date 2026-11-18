package com.example.departmentscreen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import com.example.departmentscreen.data.AppDatabase
import com.example.departmentscreen.data.DepartmentRepository
import com.example.departmentscreen.ui.DepartmentViewerScreen
import com.example.departmentscreen.ui.DepartmentViewModel
import com.example.departmentscreen.ui.DepartmentViewModelFactory
import com.example.departmentscreen.ui.theme.DepartmentScreenTheme

class MainActivity : ComponentActivity() {

    private val viewModel: DepartmentViewModel by viewModels {
        val database = AppDatabase.getDatabase(applicationContext)
        val repository = DepartmentRepository(database.departmentDao())
        DepartmentViewModelFactory(repository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DepartmentScreenTheme {
                DepartmentViewerScreen(viewModel = viewModel)
            }
        }
    }
}
