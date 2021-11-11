package com.mikhailovalx.clientsview.core.extensions

import androidx.navigation.NavController
import com.mikhailovalx.clientsview.core.IScreen

fun NavController.open(screen: IScreen) {
    this.navigate(screen.route)
}

fun NavController.openWith(screen: IScreen, param: Any) {
    this.navigate("${screen.route}/$param")
}

fun navParams(screen: IScreen, param: String): String {
    return "${screen.route}/{$param}"
}