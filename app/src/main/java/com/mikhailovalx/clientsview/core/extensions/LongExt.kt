package com.mikhailovalx.clientsview.core.extensions

import com.mikhailovalx.clientsview.core.DatePatterns.DEFAULT_DATE_PATTERN
import java.text.SimpleDateFormat
import java.util.*

fun Long.toStringDate(): String {
    if (this == 0L) return ""

    val formatter = SimpleDateFormat(DEFAULT_DATE_PATTERN, Locale.getDefault())
    val calendar: Calendar = Calendar.getInstance()
    calendar.timeInMillis = this
    return formatter.format(calendar.time)
}