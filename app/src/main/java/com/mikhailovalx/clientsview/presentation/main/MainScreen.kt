package com.mikhailovalx.clientsview.presentation.main

import androidx.compose.material.FabPosition
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.mikhailovalx.clientsview.navigation.BottomNavigationBar
import com.mikhailovalx.clientsview.navigation.Navigation
import com.mikhailovalx.clientsview.theme.TurquoiseColor
import com.mikhailovalx.clientsview.theme.WhiteColor
import com.mikhailovalx.clientsview.ui.action_bar.TopBar

@Composable
fun MainScreen() {
    val navController = rememberNavController()
    Scaffold(
        topBar = { TopBar() },
        bottomBar = { BottomNavigationBar(navController) },
        floatingActionButton = {
            FloatingActionButton(
                backgroundColor = TurquoiseColor,
                onClick = {
                    navController.navigate("nav_client_info")
                }
            ) {
                Icon(imageVector = Icons.Rounded.Add, contentDescription = "fab", tint = WhiteColor)
            }
        },
        floatingActionButtonPosition = FabPosition.Center,
        isFloatingActionButtonDocked = true
    ) {
        Navigation(navController = navController)
    }
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    MainScreen()
}