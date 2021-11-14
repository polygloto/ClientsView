package com.mikhailovalx.clientsview.presentation.common

import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.mikhailovalx.clientsview.R
import com.mikhailovalx.clientsview.theme.AccentColor
import com.mikhailovalx.clientsview.theme.ActionBarItemColor
import com.mikhailovalx.clientsview.theme.PrimaryColor
import com.mikhailovalx.clientsview.theme.WhiteColor

/**
 * Icon-button for action bar menu
 */
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

@Composable
fun RoundedButtonView(
    modifier: Modifier = Modifier,
    backCircleSize: Dp = 52.dp,
    frontCircleSize: Dp = 36.dp,
    iconHeight: Dp = 14.dp,
    iconWidth: Dp = 14.dp,
    @DrawableRes iconId: Int,
    @ColorRes iconTint: Color = WhiteColor,
    @ColorRes frontCircleColor: Color = PrimaryColor
) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ) {
        CircleView(
            color = WhiteColor,
            size = backCircleSize,
        )

        CircleView(
            color = frontCircleColor,
            size = frontCircleSize,
        )

        Icon(
            modifier = Modifier
                .size(height = iconHeight, width = iconWidth),
            painter = painterResource(id = iconId),
            contentDescription = null,
            tint = iconTint
        )
    }
}

@Preview
@Composable
fun ButtonsPreview() {
    RoundedButtonView(iconId = R.drawable.ic_fast_call)
}