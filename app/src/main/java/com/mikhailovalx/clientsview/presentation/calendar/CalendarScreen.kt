package com.mikhailovalx.clientsview.presentation.calendar

import androidx.compose.foundation.layout.Column
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import com.mikhailovalx.clientsview.models.calendar.CalendarUi
import com.mikhailovalx.clientsview.models.calendar.Day

@ExperimentalMaterialApi
@Composable
fun CalendarScreen(
    viewModel: CalendarViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsState()

    CalendarScreenContent(
        calendar = state.calendarUi,
        onDayClicked = { viewModel.sendEvent(CalendarScreenEvent.OnDayClicked(day = it)) }
    )

    LaunchedEffect(key1 = Unit, block = {
        viewModel.sendEvent(CalendarScreenEvent.FetchEvent)
    })
}

@ExperimentalMaterialApi
@Composable
fun CalendarScreenContent(
    calendar: CalendarUi,
    onDayClicked: (Day) -> Unit
) {
    CalendarView(
        calendar = calendar,
        onDayClicked = onDayClicked
    )
}

@ExperimentalMaterialApi
@Composable
fun CalendarView(
    calendar: CalendarUi,
    onDayClicked: (Day) -> Unit
) {
    Column() {
        WeekHeaderView()
        calendar.weeks.forEach { week ->
            WeekRowView(
                week = week,
                onDayClicked = onDayClicked
            )
        }
    }
}