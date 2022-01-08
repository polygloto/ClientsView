package com.mikhailovalx.clientsview.presentation.calendar

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.mikhailovalx.clientsview.models.calendar.Week


@Composable
fun WeekRowView(
    modifier: Modifier = Modifier,
    week: Week
) {
    Row(modifier = modifier) {
        week.days.forEach { day ->
            DayView(
                modifier = modifier
                    .weight(1f)
                    .padding(horizontal = 4.dp),
                day = day
            )
        }
    }
}