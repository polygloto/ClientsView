package com.mikhailovalx.clientsview.presentation.main

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.mikhailovalx.clientsview.navigation.NavigationScreen
import com.mikhailovalx.clientsview.navigation.ScreenRoutes
import com.mikhailovalx.clientsview.presentation.client.create.CreateClientScreen
import com.mikhailovalx.clientsview.presentation.client.info.ClientInfoScreen
import com.mikhailovalx.clientsview.theme.MainTheme

@Composable
fun MainScreen() {
    MainTheme {
        Surface() {
            Column(modifier = Modifier.fillMaxSize()) {
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = ScreenRoutes.Main.route,
                    modifier = Modifier.weight(1F)
                ) {
                    composable(ScreenRoutes.Main.route) { NavigationScreen(navController) }
                    composable(ScreenRoutes.ClientInfo.route) { ClientInfoScreen() }
                    composable(ScreenRoutes.CreateEditClient.route) {
                        CreateClientScreen(
                            onBackPressed = { navController.popBackStack() }
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    MainScreen()
}