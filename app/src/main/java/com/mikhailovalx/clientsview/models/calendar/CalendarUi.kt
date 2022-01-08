package com.mikhailovalx.clientsview.models.calendar

import java.util.*

data class CalendarUi(
    val days: List<Day>,
    val selectedMonthTitle: String,
    val currentMonth: Calendar,
    val weeks: List<Week>
)