package com.mikhailovalx.clientsview.presentation.calendar

import com.mikhailovalx.clientsview.core.base.BaseViewModel
import com.mikhailovalx.clientsview.core.extensions.getNextMonth
import com.mikhailovalx.clientsview.core.extensions.getPreviousMonth
import com.mikhailovalx.clientsview.domain.use_case.IGetMonthCalendarUseCase
import com.mikhailovalx.clientsview.models.calendar.Day
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CalendarViewModel @Inject constructor(
    private val getCalendarUseCase: IGetMonthCalendarUseCase
) : BaseViewModel<CalendarScreenState, CalendarScreenEvent>() {
    override val initialState: CalendarScreenState = CalendarScreenState.initial

    override fun reduce(oldState: CalendarScreenState, event: CalendarScreenEvent) {
        launchIoTryCatch {
            when (event) {
                is CalendarScreenEvent.FetchEvent -> handleFetchEvent(oldState)
                is CalendarScreenEvent.NextMonthEvent -> handleNextMonthClicked(oldState)
                is CalendarScreenEvent.PreviousMonthEvent -> handlePreviousMonthClicked(oldState)
                is CalendarScreenEvent.OnDayClicked -> handleOnDayClicked(oldState, event.day)
            }
        }
    }

    private suspend fun handleFetchEvent(oldState: CalendarScreenState) {
        val calendarUi = getCalendarUseCase(params = oldState.calendarUi.currentMonth)
        val newState = CalendarScreenState(calendarUi = calendarUi)
        setState(newState)
    }

    private suspend fun handleNextMonthClicked(oldState: CalendarScreenState) {
        val calendarUi =
            getCalendarUseCase(params = oldState.calendarUi.currentMonth.getNextMonth())
        val newState = CalendarScreenState(calendarUi = calendarUi)
        setState(newState)
    }

    private suspend fun handlePreviousMonthClicked(oldState: CalendarScreenState) {
        val calendarUi =
            getCalendarUseCase(params = oldState.calendarUi.currentMonth.getPreviousMonth())
        val newState = CalendarScreenState(calendarUi = calendarUi)
        setState(newState)
    }

    private fun handleOnDayClicked(oldState: CalendarScreenState, clickedDay: Day) {
        val updatedList = oldState.calendarUi.days.map {
            if (it.date == clickedDay.date) {
                it.copy(isSelected = !it.isSelected)
            } else {
                it
            }
        }

        val calendarUi = oldState.calendarUi.copy(days = updatedList)
        val newState = CalendarScreenState(calendarUi = calendarUi)
        setState(newState)
    }
}