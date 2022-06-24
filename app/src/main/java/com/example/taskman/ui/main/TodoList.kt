package com.example.taskman.ui.main

import android.util.Log
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.taskman.models.TodoItem

@Composable
fun TodoList(itemsList: List<TodoItem>) {
    LazyColumn(modifier = Modifier.padding(bottom = 16.dp)) {
        items(itemsList){ item->
            TodoItem(item = item) {
                Log.i("clicked", it.Title)
            }
        }
    }
    
}