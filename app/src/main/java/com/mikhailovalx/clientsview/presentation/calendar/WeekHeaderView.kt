package com.mikhailovalx.clientsview.presentation.calendar

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.text.style.TextAlign
import com.mikhailovalx.clientsview.R


@Composable
fun WeekHeaderView(
    modifier: Modifier = Modifier
) {
    val daysOfWeek = stringArrayResource(id = R.array.days_of_week)

    Row(modifier = modifier) {
        daysOfWeek.forEach { dayOfWeek ->
            Text(
                textAlign = TextAlign.Center,
                text = dayOfWeek,
                modifier = modifier
                    .weight(1f)
                    .wrapContentHeight()
            )
        }
    }
}