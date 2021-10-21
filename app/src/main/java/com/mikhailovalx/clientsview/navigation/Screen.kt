package com.mikhailovalx.clientsview.navigation

import com.mikhailovalx.clientsview.core.IScreen

sealed class Screen(
    override val route: String
): IScreen {
    object ClientInfo : Screen(route = ScreenNames.CLIENT_INFO)
    object Clients : Screen(route = ScreenNames.CLIENTS)
    object Calendar : Screen(route = ScreenNames.CALENDAR)
    object Finance : Screen(route = ScreenNames.FINANCE)
    object Settings : Screen(route = ScreenNames.SETTINGS)

    private object ScreenNames {
        const val CLIENT_INFO = "client_info"
        const val CLIENTS = "clients"
        const val CALENDAR = "calendar"
        const val FINANCE = "finance"
        const val SETTINGS = "settings"
    }
}