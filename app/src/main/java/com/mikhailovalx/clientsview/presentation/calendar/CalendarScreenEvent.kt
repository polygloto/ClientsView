package com.mikhailovalx.clientsview.presentation.calendar

import com.mikhailovalx.clientsview.core.IEvent
import com.mikhailovalx.clientsview.core.IState
import com.mikhailovalx.clientsview.models.calendar.CalendarUi
import com.mikhailovalx.clientsview.models.calendar.Day
import java.util.*
import javax.annotation.concurrent.Immutable

@Immutable
sealed class CalendarScreenEvent : IEvent {
    object FetchEvent : CalendarScreenEvent()
    object NextMonthEvent : CalendarScreenEvent()
    object PreviousMonthEvent : CalendarScreenEvent()
    data class OnDayClicked(val day: Day) : CalendarScreenEvent()
}

@Immutable
data class CalendarScreenState(
    val calendarUi: CalendarUi
) : IState {
    companion object {
        val initial = CalendarScreenState(
            calendarUi = CalendarUi(
                days = emptyList(),
                selectedMonthTitle = "",
                currentMonth = Calendar.getInstance(),
                weeks = emptyList()
            )
        )
    }
}