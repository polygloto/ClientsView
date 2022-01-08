package com.mikhailovalx.clientsview.core.extensions

import java.util.*

fun Calendar.moveToStart() {
    this.set(Calendar.DAY_OF_MONTH, 1)
    val monthBeginningDay = this.get(Calendar.DAY_OF_WEEK) - 2
    this.add(Calendar.DAY_OF_MONTH, -monthBeginningDay)
}


fun Calendar.plusDay() {
    this.add(Calendar.DAY_OF_MONTH, 1)
}

fun Calendar.getNextMonth(): Calendar {
    val calendar = this.clone() as Calendar
    calendar.add(Calendar.MONTH, 1)
    return calendar
}

fun Calendar.getPreviousMonth(): Calendar {
    val calendar = this.clone() as Calendar
    calendar.add(Calendar.MONTH, -1)
    return calendar
}

fun Calendar.isCurrentMonth(today: Calendar): Boolean {
    val sameMonth = this.get(Calendar.MONTH) == today.get(Calendar.MONTH)
    val sameYear = this.get(Calendar.YEAR) == today.get(Calendar.YEAR)

    return sameMonth && sameYear
}

fun Calendar.isCurrentDay(today: Calendar): Boolean {
    return this.get(Calendar.DATE) == today.get(Calendar.DATE)
}

fun Calendar.getDayOfMonth(): String = this.get(Calendar.DAY_OF_MONTH).toString()