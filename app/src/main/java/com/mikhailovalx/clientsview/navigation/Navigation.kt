package com.mikhailovalx.clientsview.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.mikhailovalx.clientsview.presentation.calendar.CalendarScreen
import com.mikhailovalx.clientsview.presentation.client.ClientsScreen
import com.mikhailovalx.clientsview.FinanceScreen
import com.mikhailovalx.clientsview.SettingsScreen
import com.mikhailovalx.clientsview.presentation.client.ClientInfo

@Composable
fun Navigation(navController: NavHostController) {
    NavHost(navController, startDestination = BottomNavigationItem.Clients.route) {
        composable(BottomNavigationItem.Clients.route) {
            ClientsScreen(hiltViewModel())
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
        composable(Screen.ClientInfo.route){
            ClientInfo()
        }
    }
}