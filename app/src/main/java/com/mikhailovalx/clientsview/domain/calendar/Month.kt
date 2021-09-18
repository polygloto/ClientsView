package com.mikhailovalx.clientsview.domain.calendar

data class Month(
    val month: Int,
    val year: Int,
    val days: List<Day>
)