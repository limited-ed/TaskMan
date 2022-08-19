package com.example.taskman.ui.main

import android.annotation.SuppressLint
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.taskman.data.TodoRepository
import com.example.taskman.viewmodel.TodoViewModel

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MainScreen(navController: NavController, vm: TodoViewModel){

    if (vm.items.value == null) vm.getData()

    Scaffold {
        TodoList(vm)
    }
}