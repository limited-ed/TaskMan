package com.example.taskman.ui.main

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp

@Composable
fun TodoList(itemsList: List<String>) {
    LazyColumn(contentPadding = PaddingValues(bottom = 16.dp)) {
        items(itemsList){ item->
            TodoItem(item = item)
        }
    }
    
}