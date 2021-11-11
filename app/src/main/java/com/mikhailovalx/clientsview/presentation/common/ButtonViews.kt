package com.mikhailovalx.clientsview.presentation.common

import androidx.annotation.DrawableRes
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import com.mikhailovalx.clientsview.theme.ActionBarItemColor


@Composable
fun ActionButtonView(
    onClick: () -> Unit,
    @DrawableRes iconId: Int
) {
    IconButton(onClick = onClick) {
        Icon(
            painter = painterResource(id = iconId),
            contentDescription = null,
            tint = ActionBarItemColor
        )
    }
}
