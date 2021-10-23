package com.mikhailovalx.clientsview.navigation

import com.mikhailovalx.clientsview.core.IScreen

sealed class ScreenRoutes(
    override val route: String
): IScreen {
    object Main : ScreenRoutes(route = ScreenNames.MAIN)
    object ClientInfo : ScreenRoutes(route = ScreenNames.CLIENT_INFO)

    private object ScreenNames {
        const val CLIENT_INFO = "client_info"
        const val MAIN = "main"
    }
}