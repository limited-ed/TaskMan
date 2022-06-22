package com.example.taskman.ui

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.taskman.ui.main.MainScreen
import com.example.taskman.ui.theme.TaskManTheme
import androidx.compose.ui.unit.dp
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.taskman.ui.add.AddScreen


class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            val showBackButton by derivedStateOf {  navController.previousBackStackEntry != null }

            TaskManTheme {
                Scaffold(
                    topBar = {

                        TopAppBar(
                            title = { Text(text = "TaskMan")},
                            navigationIcon = AutoNavigationIcon(navController)
                        )
                    },
                    isFloatingActionButtonDocked = true,
                    floatingActionButton = {
                        AddButton(navController)
                    },
                    bottomBar = {
                        BottomBar(navController)
                    }
                ) {
                    NavComponent(navController)
                }
            }
        }
    }
}

@Composable
fun NavComponent(navController: NavHostController){
    NavHost(navController = navController, startDestination = "main"){
        composable("main") {
            MainScreen(navController)
        }
        composable("add"){
            AddScreen()
        }
    }
}

@Composable
fun AddButton(navController: NavController): Unit? {
    val currentBackStackEntry: NavBackStackEntry? by navController.currentBackStackEntryAsState()
    return currentBackStackEntry?.let {
        if (currentBackStackEntry?.destination?.route=="main"){
            FloatingActionButton(onClick = {
                navController.navigate("add")
            }) {
                Icon(imageVector = Icons.Filled.Add, contentDescription = "Add" )
            }

        }

    }

}

@Composable
fun BottomBar(navController: NavController): Unit? {
    val currentBackStackEntry: NavBackStackEntry? by navController.currentBackStackEntryAsState()
    return currentBackStackEntry?.let {
        if (currentBackStackEntry?.destination?.route=="main"){
            BottomAppBar(cutoutShape = MaterialTheme.shapes.small.copy(
                CornerSize(percent = 50))){}
        }

    }

}