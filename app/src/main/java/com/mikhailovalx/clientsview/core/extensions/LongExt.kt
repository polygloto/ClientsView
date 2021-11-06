package com.mikhailovalx.clientsview.core.extensions

import java.text.SimpleDateFormat
import java.util.*

fun Long.toDate(): String {
    val formatter = SimpleDateFormat("dd.MM.yyyy", Locale.getDefault())
    val calendar: Calendar = Calendar.getInstance()
    calendar.timeInMillis = this
    return formatter.format(calendar.time)
}