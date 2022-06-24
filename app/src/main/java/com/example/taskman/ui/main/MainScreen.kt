package com.example.taskman.ui.main

import android.annotation.SuppressLint
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.taskman.data.TodoRepository

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MainScreen(navController: NavController){
    val repository = TodoRepository()
    Scaffold {
        TodoList(itemsList = repository.getAllTodo())
    }
}