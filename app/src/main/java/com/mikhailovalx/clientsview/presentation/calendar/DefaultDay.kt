package com.mikhailovalx.clientsview.presentation.calendar

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mikhailovalx.clientsview.models.calendar.Day
import com.mikhailovalx.clientsview.theme.AccentColor
import com.mikhailovalx.clientsview.theme.LabelIconsColor
import com.mikhailovalx.clientsview.theme.PrimaryTextColor
import com.mikhailovalx.clientsview.theme.WhiteColor


@ExperimentalMaterialApi
@Composable
fun DayView(
    modifier: Modifier = Modifier,
    day: Day,
    onDayClicked: (Day) -> Unit
) {
    val textColor = if (day.isCurrentMonth) {
        PrimaryTextColor
    } else {
        LabelIconsColor
    }

    // TODO color does not change D:

    val cardColor = if (day.isSelected) {
        AccentColor
    } else {
        WhiteColor
    }

    Card(
        modifier = modifier
            .height(32.dp)
            .padding(2.dp),
        elevation = 4.dp,
        backgroundColor = cardColor,
        onClick = { onDayClicked(day) }
    ) {
        Box(
            contentAlignment = Alignment.Center,
        ) {
            Text(
                text = day.title,
                fontSize = 12.sp,
                color = textColor
            )
        }
    }
}