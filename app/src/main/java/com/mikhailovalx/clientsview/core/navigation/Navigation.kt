package com.mikhailovalx.clientsview.core.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.mikhailovalx.clientsview.ui.calendar.CalendarScreen
import com.mikhailovalx.clientsview.ClientsScreen
import com.mikhailovalx.clientsview.FinanceScreen
import com.mikhailovalx.clientsview.SettingsScreen
import com.mikhailovalx.clientsview.ui.client.ClientInfo

@Composable
fun Navigation(navController: NavHostController) {
    NavHost(navController, startDestination = BottomNavigationItem.Clients.route) {
        composable(BottomNavigationItem.Clients.route) {
            ClientsScreen()
        }
        composable(BottomNavigationItem.Calendar.route) {
            CalendarScreen()
        }
        composable(BottomNavigationItem.Finance.route) {
            FinanceScreen()
        }
        composable(BottomNavigationItem.Settings.route) {
            SettingsScreen()
        }
        composable("nav_client_info"){
            ClientInfo()
        }
    }
}