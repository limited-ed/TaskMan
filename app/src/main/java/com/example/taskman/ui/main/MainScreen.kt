package com.example.taskman.ui.main

import android.annotation.SuppressLint
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MainScreen(navController: NavController){
    Scaffold {
        TodoList(itemsList = listOf("111","2222","2333"))
    }
}