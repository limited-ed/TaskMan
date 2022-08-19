package com.example.taskman.viewmodel

import androidx.compose.runtime.structuralEqualityPolicy
import androidx.lifecycle.MutableLiveData
import com.example.taskman.data.TodoRepository
import com.example.taskman.models.TodoItem
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class TodoViewModel (private val repository: TodoRepository) {

    private val _isLoading: MutableStateFlow<Boolean> = MutableStateFlow(false)
    val isLoading = _isLoading.asStateFlow()

    val items: MutableLiveData<List<TodoItem>> by lazy { MutableLiveData<List<TodoItem>>() }

    fun getData(){
        MainScope().launch {
            _isLoading.value = true

            withContext(Dispatchers.IO) {
                delay(2000)

            }
            items.value=repository.getAllTodo()
            _isLoading.value = false
        }
    }
}