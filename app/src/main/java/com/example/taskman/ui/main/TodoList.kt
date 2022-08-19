package com.example.taskman.ui.main

import android.util.Log
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.dp
import com.example.taskman.models.TodoItem
import com.example.taskman.viewmodel.TodoViewModel

@Composable
fun TodoList(vm: TodoViewModel) {

    if (vm.isLoading.collectAsState().value) {
        CircularProgressIndicator()
    } else {
        if (vm.items.value != null){
            LazyColumn(modifier = Modifier.testTag("list").padding(bottom = 16.dp)) {
                items(vm.items.value!!){ item->
                    TodoItem(item = item) {
                        Log.i("clicked", it.Title)
                    }
                }
            }
        }

    }


    
}