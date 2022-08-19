package com.example.taskman

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.navigation.testing.TestNavHostController
import androidx.test.core.app.ApplicationProvider
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.taskman.data.TodoRepository
import com.example.taskman.ui.main.MainScreen
import com.example.taskman.viewmodel.TodoViewModel

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule


/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    @get:Rule
    val composeTestRule = createComposeRule()
    lateinit var navController: TestNavHostController

    @Before
    fun setup() {
        navController = TestNavHostController(ApplicationProvider.getApplicationContext())
    }

    @Test
    fun runMainScreen() {
        val vm=TodoViewModel(TodoRepository())
        composeTestRule.setContent {
            MainScreen(navController = navController, vm = vm)
        }
        composeTestRule.waitUntil {
           !vm.items.value.isNullOrEmpty()
        }
        composeTestRule.onNodeWithTag("list").assertIsDisplayed()

    }
}