package com.mikhailovalx.clientsview.navigation

import com.mikhailovalx.clientsview.R

sealed class BottomNavigationItem(var route: String, var icon: Int, var title: String) {
    object Clients : BottomNavigationItem("clients", R.drawable.ic_clients, "Клиенты")
    object Calendar : BottomNavigationItem("calendar", R.drawable.ic_calendar, "Календарь")
    object fab : BottomNavigationItem("fab", 0, "") // empty item for fab
    object Finance : BottomNavigationItem("finance", R.drawable.ic_finance, "Финансы")
    object Settings : BottomNavigationItem("settings", R.drawable.ic_settings, "Настройки")
}
