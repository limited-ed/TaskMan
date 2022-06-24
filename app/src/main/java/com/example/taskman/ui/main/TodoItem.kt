package com.example.taskman.ui.main

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.taskman.models.TodoItem

@Composable
fun TodoItem(item: TodoItem, onClick: (item: TodoItem) -> Unit) {
    var checked by remember { mutableStateOf (item.Done) }
    Card(
        shape = RoundedCornerShape(8.dp),
        backgroundColor = MaterialTheme.colors.surface,
        elevation = 2.dp,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp, start = 16.dp, end = 16.dp)
            .clickable { onClick(item) }

    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Column (modifier = Modifier
                .weight(1f)
                .padding(16.dp)){
                Text(text = item.Title)
                Text(text = item.TodoText, overflow = TextOverflow.Visible)
            }
            Checkbox(checked = checked, onCheckedChange = {
                    checked = it
                    item.Done = it
                })
            Icon(imageVector = Icons.Filled.Delete, contentDescription = "Delete",
                modifier = Modifier.padding(end = 16.dp) )
        }

    }
}

@Preview
@Composable
fun TodoItemPreview(){
    Card(
        shape = RoundedCornerShape(8.dp),
        backgroundColor = MaterialTheme.colors.surface,
        elevation = 2.dp,
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)


    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Column (modifier = Modifier
                .weight(1f)
                .padding(16.dp)){
                Text(text = "item.Title")
                Text(text = "item.TodoText", overflow = TextOverflow.Visible)
            }
            Checkbox(checked = false, onCheckedChange = {})
            Icon(imageVector = Icons.Filled.Delete, contentDescription = "Delete" )
        }
    }
}