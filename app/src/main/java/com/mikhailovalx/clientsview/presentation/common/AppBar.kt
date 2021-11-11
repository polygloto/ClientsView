package com.mikhailovalx.clientsview.presentation.common

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.sp
import com.mikhailovalx.clientsview.theme.PrimaryTextColor
import com.mikhailovalx.clientsview.theme.WhiteColor

@Composable
fun AppBar(
    title: String,
    onBackPressed: () -> Unit,
    actions: @Composable RowScope.() -> Unit = {}
) {
    TopAppBar(
        title = { Text(text = title, fontSize = 18.sp) },
        contentColor = PrimaryTextColor,
        backgroundColor = WhiteColor,
        navigationIcon = {
            IconButton(onClick = onBackPressed) {
                Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = null)
            }
        },
        actions = actions
    )
}