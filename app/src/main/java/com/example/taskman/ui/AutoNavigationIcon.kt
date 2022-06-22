package com.example.taskman.ui

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.*
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController

/**
 * Gets the previous navigation back stack entry as a [MutableState]. When the given navController
 * changes the back stack due to a [NavController.navigate] or [NavController.popBackStack] this
 * will trigger a recompose and return the second top entry on the back stack.
 *
 * @return a mutable state of the previous back stack entry
 */
@Composable
fun NavController.previousBackStackEntryAsState(): State<NavBackStackEntry?> {
    val previousNavBackStackEntry = remember { mutableStateOf(previousBackStackEntry) }
    // setup the onDestinationChangedListener responsible for detecting when the
    // previous back stack entry changes
    DisposableEffect(this) {
        val callback = NavController.OnDestinationChangedListener { controller, _, _ ->
            previousNavBackStackEntry.value = controller.previousBackStackEntry
        }
        addOnDestinationChangedListener(callback)
        // remove the navController on dispose (i.e. when the composable is destroyed)
        onDispose {
            removeOnDestinationChangedListener(callback)
        }
    }
    return previousNavBackStackEntry
}


@Composable
fun AutoNavigationIcon(navController: NavController): @Composable (() -> Unit)? {
    val previousBackStackEntry: NavBackStackEntry? by navController.previousBackStackEntryAsState()
    return previousBackStackEntry?.let {
        {
            IconButton(onClick = {
                navController.popBackStack()
            }) {
                Icon(Icons.Default.ArrowBack, contentDescription = "Up button")
            }
        }
    }
}