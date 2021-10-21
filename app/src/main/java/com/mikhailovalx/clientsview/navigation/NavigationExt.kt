package com.mikhailovalx.clientsview.navigation

import androidx.navigation.NavController
import com.mikhailovalx.clientsview.core.IScreen

fun NavController.open(screen: IScreen) {
    this.navigate(screen.route)
}