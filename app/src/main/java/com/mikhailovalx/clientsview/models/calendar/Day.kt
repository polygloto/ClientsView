package com.mikhailovalx.clientsview.models.calendar

import java.util.*

data class Day(
    val date: Date,
    val isCurrentMonth: Boolean,
    val isToday: Boolean = false,
    val isSelected: Boolean = false,
    val hasEvents: Boolean = false,
    val title: String
)
