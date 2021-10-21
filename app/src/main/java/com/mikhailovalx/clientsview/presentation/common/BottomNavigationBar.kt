package com.mikhailovalx.clientsview.presentation.common

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.compose.currentBackStackEntryAsState
import com.mikhailovalx.clientsview.navigation.BottomNavigationItem
import com.mikhailovalx.clientsview.theme.WhiteColor

@Composable
fun BottomNavigationBar(navController: NavController) {
    val items = listOf(
        BottomNavigationItem.Clients,
        BottomNavigationItem.Calendar,
        BottomNavigationItem.fab,
        BottomNavigationItem.Finance,
        BottomNavigationItem.Settings
    )
    BottomAppBar(
        backgroundColor = WhiteColor,
        cutoutShape = CircleShape,
        contentColor = Color.Blue,
        elevation = 10.dp,
        contentPadding = PaddingValues(0.dp)
    ) {
        items.forEachIndexed { index, item ->
            if (index == 2) {
                // empty item for fab
                BottomNavigationItem(
                    icon = {},
                    label = { },
                    selected = false,
                    onClick = { },
                    enabled = false
                )
                return@forEachIndexed
            }

            val navBackStackEntry by navController.currentBackStackEntryAsState()
            val currentDestination = navBackStackEntry?.destination

            BottomNavigationItem(
                icon = { Icon(painterResource(id = item.icon), contentDescription = item.title) },
                label = { Text(text = item.title, fontSize = 10.sp, maxLines = 1) },
                selectedContentColor = Color.Black,
                unselectedContentColor = Color.Black.copy(0.4f),
                alwaysShowLabel = true,
                selected = currentDestination?.hierarchy?.any { it.route == item.route } == true,
                onClick = {
                    navController.navigate(item.route) {
                        //Pop up to the start destination of the graph to
                        //avoid building up a large stack of destinations
                        //on the back stack as users select items
                        navController.graph.startDestinationRoute?.let { route ->
                            popUpTo(route) {
                                saveState = true
                            }
                        }
                        // Avoid multiple copies of the same destination when reselecting the same item
                        launchSingleTop = true
                        // Restore state when reselecting a previously selected item
                        restoreState = true
                    }
                }
            )
        }
    }
}