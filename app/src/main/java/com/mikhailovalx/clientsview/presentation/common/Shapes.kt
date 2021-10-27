package com.mikhailovalx.clientsview.presentation.common

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.mikhailovalx.clientsview.theme.TurquoiseColor

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

@Composable
fun SemiCircleView(
    color: Color,
    size: Dp
) {
    Canvas(
        modifier = Modifier.size(size)
    )
    {
        drawArc(
            color = color,
            startAngle = 90F,
            sweepAngle = 180F,
            useCenter = true,
        )
    }
}

@Preview
@Composable
fun Shapes_Preview() {
    Column {
        CircleView(color = TurquoiseColor, size = 50.dp)
        SemiCircleView(color = TurquoiseColor, size = 50.dp)
    }
}