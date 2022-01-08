package com.mikhailovalx.clientsview.presentation.calendar

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import com.mikhailovalx.clientsview.models.calendar.CalendarUi

@Composable
fun CalendarScreen(
    viewModel: CalendarViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsState()

    CalendarScreenContent(calendar = state.calendarUi)

    LaunchedEffect(key1 = Unit, block = {
        viewModel.sendEvent(CalendarScreenEvent.FetchEvent)
    })
}

@Composable
fun CalendarScreenContent(
    calendar: CalendarUi
) {
    CalendarView(calendar = calendar)
}

@Composable
fun CalendarView(
    calendar: CalendarUi
) {
    Column() {
        WeekHeaderView()
        calendar.weeks.forEach { week ->
            WeekRowView(week = week)
        }
    }
}