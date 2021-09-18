package com.mikhailovalx.clientsview.domain.calendar

import java.util.Calendar

class EventCalendar {
    private val monthInstance: Month

    init {
        monthInstance = initMonthInstance()
    }

    private fun initMonthInstance(): Month {
        val calendar = Calendar.getInstance()
        val currentDay = calendar.get(Calendar.DAY_OF_MONTH)
        val currentMonth = calendar.get(Calendar.MONTH) + 1
        val currentYear = calendar.get(Calendar.YEAR)
        val maxDays = calendar.getActualMaximum(Calendar.DAY_OF_MONTH)
        val days = mutableListOf<Day>()

        for (i in 1 .. maxDays) {
            days.add(
                Day(
                    day = i,
                    month = currentMonth,
                    year = currentYear,
                    isSelected = i == currentDay,
                    isCurrent = i == currentDay,
                    emptyList()
                )
            )
        }

        return Month(
            month = currentMonth,
            year = currentYear,
            days = days
        )
    }
}