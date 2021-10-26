package com.mikhailovalx.clientsview.presentation.common

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun CircleView(
    modifier: Modifier = Modifier,
    size: Dp,
    color: Color,
    elevation: Dp = 3.dp
) {
    Card(
        modifier = modifier,
        shape = CircleShape,
        elevation = elevation
    ) {
        Canvas(
            modifier = Modifier.size(size),
            onDraw = { drawCircle(color = color) }
        )
    }
}