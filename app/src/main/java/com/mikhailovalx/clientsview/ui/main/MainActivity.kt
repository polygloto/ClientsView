package com.mikhailovalx.clientsview.ui.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.FabPosition
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.mikhailovalx.clientsview.core.navigation.BottomNavigationBar
import com.mikhailovalx.clientsview.core.navigation.Navigation
import com.mikhailovalx.clientsview.core.theme.TurquoiseColor
import com.mikhailovalx.clientsview.core.theme.WhiteColor
import com.mikhailovalx.clientsview.domain.calendar.EventCalendar
import com.mikhailovalx.clientsview.ui.action_bar.TopBar

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val calendar = EventCalendar()


        setContent {
            MainScreen()
        }
    }
}

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