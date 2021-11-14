package com.mikhailovalx.clientsview.presentation.common

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mikhailovalx.clientsview.theme.LabelTextColor
import com.mikhailovalx.clientsview.theme.WhiteColor

@Composable
fun NumberView(
    modifier: Modifier = Modifier,
    title: String? = null,
    number: Int = 0,
    height: Dp = 54.dp,
    width: Dp = 128.dp
) {
    Column(modifier = modifier) {
        if (title != null) {
            Text(
                modifier = Modifier.padding(bottom = 8.dp),
                text = title,
                color = LabelTextColor,
                fontSize = 12.sp,
                fontWeight = FontWeight.W600
            )
        }

        Card(
            modifier = Modifier
                .height(height)
                .width(width)
                .background(WhiteColor),
            elevation = 4.dp,
            shape = RoundedCornerShape(10.dp)

        ) {
            Box(contentAlignment = Alignment.Center) {
                Text(text = number.toString())
            }
        }
    }
}