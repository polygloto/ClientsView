package com.mikhailovalx.clientsview.navigation

import com.mikhailovalx.clientsview.core.IScreen

sealed class ScreenRoutes(
    override val route: String
): IScreen {
    object Main : ScreenRoutes(route = ScreenNames.MAIN)
    object ClientInfo : ScreenRoutes(route = ScreenNames.CLIENT_INFO)
    object CreateEditClient : ScreenRoutes(route = ScreenNames.CLIENT_CREATE_EDIT)

    private object ScreenNames {
        const val MAIN = "main"
        const val CLIENT_INFO = "client_info"
        const val CLIENT_CREATE_EDIT = "client_create_edit"
    }
}