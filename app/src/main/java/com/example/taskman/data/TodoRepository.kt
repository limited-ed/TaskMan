package com.example.taskman.data

import com.example.taskman.models.TodoItem
import java.util.*

class TodoRepository {

    fun getAllTodo(): List<TodoItem> {
       return listOf(
           TodoItem(Title="First", TodoText = "First text", Expired = Date(), Done = false),
           TodoItem(Title="Second", TodoText = "Second text", Expired = Date(), Done = false),
           TodoItem(Title="Third", TodoText = "Third text", Expired = Date(), Done = false),
           TodoItem(Title="Forth", TodoText = "Forth text", Expired = Date(), Done = false),
           TodoItem(Title="Fifth", TodoText = "Fifth text", Expired = Date(), Done = false),
           TodoItem(Title="First", TodoText = "First text", Expired = Date(), Done = false),
           TodoItem(Title="Second", TodoText = "Second text", Expired = Date(), Done = false),
           TodoItem(Title="Third", TodoText = "Third text", Expired = Date(), Done = false),
           TodoItem(Title="Forth", TodoText = "Forth text", Expired = Date(), Done = false),
           TodoItem(Title="Fifth", TodoText = "Fifth text", Expired = Date(), Done = false),
       )
    }
}