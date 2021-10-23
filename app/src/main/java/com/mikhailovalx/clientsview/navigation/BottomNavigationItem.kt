package com.mikhailovalx.clientsview.navigation

import com.mikhailovalx.clientsview.R
import com.mikhailovalx.clientsview.core.IScreen

sealed class BottomNavigationItem(
    override val route: String,
    val icon: Int,
    val title: String
) : IScreen {
    object Clients : BottomNavigationItem("clients", R.drawable.ic_clients, "Клиенты")
    object Calendar : BottomNavigationItem("calendar", R.drawable.ic_calendar, "Календарь")
    object CreateButton : BottomNavigationItem("create_button", 0, "") // empty item for fab
    object Finance : BottomNavigationItem("finance", R.drawable.ic_finance, "Финансы")
    object Settings : BottomNavigationItem("settings", R.drawable.ic_settings, "Настройки")
}