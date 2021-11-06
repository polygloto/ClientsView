package com.mikhailovalx.clientsview.core.extensions

import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.datepicker.MaterialDatePicker

fun AppCompatActivity.showDatePicker(
    updatedDate: (Long) -> Unit
) {
    val picker = MaterialDatePicker.Builder.datePicker().build()
    picker.show(this.supportFragmentManager, picker.toString())
    picker.addOnPositiveButtonClickListener {
        updatedDate(it)
    }
}