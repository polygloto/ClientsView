package com.mikhailovalx.clientsview.presentation.common

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.mikhailovalx.clientsview.R
import com.mikhailovalx.clientsview.theme.AccentColor
import com.mikhailovalx.clientsview.theme.IndicatorIconColor
import com.mikhailovalx.clientsview.theme.PrimaryColor
import com.mikhailovalx.clientsview.theme.WhiteColor

@Composable
fun IndicatorView(
    modifier: Modifier = Modifier,
    isImportant: Boolean = false,
    isSemiCircle: Boolean = false,
    backCircleSize: Dp = 54.dp,
    frontCircleSize: Dp = 38.dp,
    iconHeight: Dp = 13.dp,
    iconWidth: Dp = 14.dp,
    indicatorOnColor: Color = AccentColor,
    indicatorOffColor: Color = PrimaryColor,
) {
    val indicatorColor by animateColorAsState(
        targetValue = if (isImportant) indicatorOnColor else indicatorOffColor
    )
    val iconId = if (isImportant) R.drawable.ic_heart_green else R.drawable.ic_heart
    val iconTint = if (isImportant) indicatorOnColor else IndicatorIconColor

    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ) {
        if (isSemiCircle) {
            SemiCircleView(
                color = indicatorColor,
                size = backCircleSize,
            )
        } else {
            CircleView(
                color = indicatorColor,
                size = backCircleSize,
            )
        }

        CircleView(
            color = WhiteColor,
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
fun IndicatorView_Preview() {
    IndicatorView()
}