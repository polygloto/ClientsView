package com.mikhailovalx.clientsview.presentation.common

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.mikhailovalx.clientsview.R
import com.mikhailovalx.clientsview.theme.GreenAccentColor
import com.mikhailovalx.clientsview.theme.TurquoiseColor
import com.mikhailovalx.clientsview.theme.WhiteColor

@Composable
fun IndicatorView(
    modifier: Modifier = Modifier,
    isImportant: Boolean = false,
    isSemiCircle: Boolean = false,
    backCircleSize: Dp = 54.dp,
    frontCircleSize: Dp = 38.dp,
    iconHeight: Dp = 13.dp,
    iconWidth: Dp = 14.dp
) {
    val indicatorColor = if (isImportant) GreenAccentColor else TurquoiseColor

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
            modifier = Modifier.size(height = iconHeight, width = iconWidth),
            painter = painterResource(id = R.drawable.ic_heart),
            contentDescription = null
        )
    }
}

@Preview
@Composable
fun IndicatorView_Preview() {
    IndicatorView()
}