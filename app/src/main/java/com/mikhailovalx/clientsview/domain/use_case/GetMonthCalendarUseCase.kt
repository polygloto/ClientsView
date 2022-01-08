package com.mikhailovalx.clientsview.domain.use_case

import com.mikhailovalx.clientsview.core.DatePatterns.FULL_MONTH_PATTERN
import com.mikhailovalx.clientsview.core.IUseCase
import com.mikhailovalx.clientsview.core.extensions.*
import com.mikhailovalx.clientsview.models.calendar.CalendarUi
import com.mikhailovalx.clientsview.models.calendar.Day
import com.mikhailovalx.clientsview.models.calendar.Week
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject

class GetMonthCalendarUseCase @Inject constructor(
) : IGetMonthCalendarUseCase {
    override suspend fun invoke(params: Calendar): CalendarUi {
        val calendar = params.clone() as Calendar
        val days = mutableListOf<Day>()
        val today = Calendar.getInstance()
        val monthPattern = SimpleDateFormat(FULL_MONTH_PATTERN, Locale.getDefault())
        val monthTitle = monthPattern.format(calendar.time)
        calendar.moveToStart()

        while (days.size < CALENDAR_MAX_DAYS) {
            val day = Day(
                date = calendar.time,
                isCurrentMonth = calendar.isCurrentMonth(today),
                isToday = calendar.isCurrentDay(today),
                isSelected = false,
                hasEvents = false,
                title = calendar.getDayOfMonth()
            )
            days.add(day)
            calendar.plusDay()
        }

        val weeks = days.chunked(7).map {
            Week(it)
        }

        return CalendarUi(
            days = days,
            selectedMonthTitle = monthTitle,
            currentMonth = params,
            weeks = weeks
        )
    }

    companion object {
        private const val CALENDAR_MAX_DAYS = 42
    }
}

interface IGetMonthCalendarUseCase : IUseCase.InOut<Calendar, CalendarUi>