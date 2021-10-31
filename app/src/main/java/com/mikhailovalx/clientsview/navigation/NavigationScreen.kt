package com.mikhailovalx.clientsview.navigation

import androidx.compose.material.FabPosition
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.mikhailovalx.clientsview.presentation.finance.FinanceScreen
import com.mikhailovalx.clientsview.SettingsScreen
import com.mikhailovalx.clientsview.presentation.calendar.CalendarScreen
import com.mikhailovalx.clientsview.presentation.client.list.ClientsScreen
import com.mikhailovalx.clientsview.presentation.common.BottomNavigationBar
import com.mikhailovalx.clientsview.theme.TurquoiseColor
import com.mikhailovalx.clientsview.theme.WhiteColor

@Composable
fun NavigationScreen(
    navHostController: NavHostController
) {
    val bottomNavController = rememberNavController()
    Scaffold(
        bottomBar = { BottomNavigationBar(bottomNavController) },
        floatingActionButton = {
            FloatingActionButton(
                backgroundColor = TurquoiseColor,
                onClick = { navHostController.open(ScreenRoutes.CreateEditClient) }
            ) {
                Icon(imageVector = Icons.Rounded.Add, contentDescription = "", tint = WhiteColor)
            }
        },
        floatingActionButtonPosition = FabPosition.Center,
        isFloatingActionButtonDocked = true
    ) {
        NavHost(bottomNavController, startDestination = BottomNavigationItem.Clients.route) {
            composable(BottomNavigationItem.Clients.route) { ClientsScreen(hiltViewModel()) }
            composable(BottomNavigationItem.Calendar.route) { CalendarScreen() }
            composable(BottomNavigationItem.Finance.route) { FinanceScreen() }
            composable(BottomNavigationItem.Settings.route) { SettingsScreen() }
        }
    }
}