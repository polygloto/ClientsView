package com.mikhailovalx.clientsview.presentation.main

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.mikhailovalx.clientsview.core.extensions.navParams
import com.mikhailovalx.clientsview.navigation.NavArgs.CLIENT_ID_ARG
import com.mikhailovalx.clientsview.navigation.NavigationScreen
import com.mikhailovalx.clientsview.navigation.ScreenRoutes
import com.mikhailovalx.clientsview.presentation.client.create.CreateClientScreen
import com.mikhailovalx.clientsview.presentation.client.info.ClientInfoScreen
import com.mikhailovalx.clientsview.theme.MainTheme

@ExperimentalMaterialApi
@ExperimentalAnimationApi
@ExperimentalComposeUiApi
@Composable
fun MainScreen() {
    MainTheme {
        Surface {
            Column(modifier = Modifier.fillMaxSize()) {
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = ScreenRoutes.Main.route,
                    modifier = Modifier.weight(1F)
                ) {
                    /** Screen that includes bottom navigation menu */
                    composable(ScreenRoutes.Main.route) { NavigationScreen(navController) }

                    composable(
                        route = navParams(ScreenRoutes.ClientInfo, CLIENT_ID_ARG),
                        arguments = listOf(navArgument(CLIENT_ID_ARG) { type = NavType.LongType })
                    ) { backStackEntry ->
                        backStackEntry.arguments?.getLong(CLIENT_ID_ARG)?.let { clientId ->
                            ClientInfoScreen(
                                clientId = clientId,
                                navController = navController
                            )
                        }
                    }

                    composable(
                        route = navParams(ScreenRoutes.CreateEditClient, CLIENT_ID_ARG),
                        arguments = listOf(navArgument(CLIENT_ID_ARG) {
                            type = NavType.StringType
                            nullable = true
                            defaultValue = null
                        }),
                    ) { backStackEntry ->
                        val clientId = backStackEntry.arguments?.getString(CLIENT_ID_ARG)
                        CreateClientScreen(
                            navController = navController,
                            clientId = clientId?.toLongOrNull()
                        )
                    }
                }
            }
        }
    }
}

@ExperimentalMaterialApi
@ExperimentalAnimationApi
@ExperimentalComposeUiApi
@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    MainScreen()
}