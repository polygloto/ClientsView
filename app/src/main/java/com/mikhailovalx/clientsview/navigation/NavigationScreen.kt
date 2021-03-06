package com.mikhailovalx.clientsview.navigation

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.mikhailovalx.clientsview.presentation.settings.SettingsScreen
import com.mikhailovalx.clientsview.core.extensions.openWith
import com.mikhailovalx.clientsview.presentation.calendar.CalendarScreen
import com.mikhailovalx.clientsview.presentation.client.list.ClientsScreen
import com.mikhailovalx.clientsview.presentation.common.BottomNavigationBar
import com.mikhailovalx.clientsview.presentation.finance.FinanceScreen
import com.mikhailovalx.clientsview.theme.PrimaryColor
import com.mikhailovalx.clientsview.theme.WhiteColor

@ExperimentalMaterialApi
@ExperimentalComposeUiApi
@Composable
fun NavigationScreen(
        navHostController: NavHostController
) {
    val navController = rememberNavController()
    Scaffold(
            bottomBar = { BottomNavigationBar(navController) },
            floatingActionButton = {
                FloatingActionButton(
                        backgroundColor = PrimaryColor,
                        onClick = { navHostController.openWith(ScreenRoutes.CreateEditClient, null) }
                ) {
                    Icon(imageVector = Icons.Rounded.Add, contentDescription = "", tint = WhiteColor)
                }
            },
            floatingActionButtonPosition = FabPosition.Center,
            isFloatingActionButtonDocked = true
    ) {
        NavHost(navController, startDestination = BottomNavigationItem.Clients.route) {
            composable(BottomNavigationItem.Clients.route) {
                ClientsScreen(navController = navHostController)
            }
            composable(BottomNavigationItem.Calendar.route) { CalendarScreen() }
            composable(BottomNavigationItem.Finance.route) { FinanceScreen() }
            composable(BottomNavigationItem.Settings.route) { SettingsScreen() }
        }
    }
}