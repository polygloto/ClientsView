package com.mikhailovalx.clientsview.domain.calendar

data class Day(
    val day: Int,
    val month: Int,
    val year: Int,
    val isSelected: Boolean,
    val isCurrent: Boolean,
    val events: List<Event>
) {
    val hasEvents
        get() = events.isNotEmpty()
}
