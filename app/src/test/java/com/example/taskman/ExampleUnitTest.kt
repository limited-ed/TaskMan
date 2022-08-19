package com.example.taskman

import com.example.taskman.data.TodoRepository
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun get_data(){
        var rep = TodoRepository()
        var data = rep.getAllTodo()
        assertNotNull(data)
        assertNotEquals(data.size, 0)
    }
}