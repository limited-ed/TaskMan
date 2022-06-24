package com.example.taskman.models

import java.util.*

data class TodoItem(var Title: String, var TodoText: String,
                    var Expired: Date, var Done: Boolean)
