package com.mikhailovalx.clientsview.presentation.main

import androidx.compose.material.FabPosition
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.mikhailovalx.clientsview.presentation.common.BottomNavigationBar
import com.mikhailovalx.clientsview.navigation.Navigation
import com.mikhailovalx.clientsview.navigation.Screen
import com.mikhailovalx.clientsview.navigation.open
import com.mikhailovalx.clientsview.theme.TurquoiseColor
import com.mikhailovalx.clientsview.theme.WhiteColor
import com.mikhailovalx.clientsview.ui.action_bar.TopBar

@Composable
fun MainScreen() {
    val navController = rememberNavController()
    Scaffold(
        topBar = { TopBar()},
        bottomBar = {
            if (isBottomScreen(navController)) {
                BottomNavigationBar(navController)
            }
        },
        floatingActionButton = {
            if (isBottomScreen(navController)) {
                FloatingActionButton(
                    backgroundColor = TurquoiseColor,
                    onClick = { navController.open(Screen.ClientInfo) }
                ) {
                    Icon(imageVector = Icons.Rounded.Add, contentDescription = "fab", tint = WhiteColor)
                }
            }
        },
        floatingActionButtonPosition = FabPosition.Center,
        isFloatingActionButtonDocked = true
    ) {
        Navigation(navController = navController)
    }
}

@Composable
fun isBottomScreen(navController: NavHostController): Boolean {
    return when (navController.currentBackStackEntry?.destination?.route) {
        Screen.Clients.route,
        Screen.Calendar.route,
        Screen.Finance.route,
        Screen.Settings.route,
        null -> true
        else -> false
    }
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    MainScreen()
}