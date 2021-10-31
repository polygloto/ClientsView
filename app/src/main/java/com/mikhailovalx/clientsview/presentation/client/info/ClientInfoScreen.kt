package com.mikhailovalx.clientsview.presentation.client.info

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.mikhailovalx.clientsview.R
import com.mikhailovalx.clientsview.presentation.common.LabelView
import com.mikhailovalx.clientsview.presentation.common.StepperView

@Composable
fun ClientInfoScreen() {
    Column {
        LabelView(
            icon = R.drawable.ic_person,
            text = "",
            title = "Имя клиента",
            modifier = Modifier.padding(top = 16.dp, start = 24.dp, end = 24.dp)
        )

        LabelView(
            icon = R.drawable.ic_calendar_check,
            text = "",
            title = "Дата рождения",
            modifier = Modifier.padding(top = 16.dp, start = 24.dp, end = 24.dp)
        )

        LabelView(
            icon = R.drawable.ic_phone,
            text = "",
            title = "Номер телефона",
            modifier = Modifier.padding(top = 16.dp, start = 24.dp, end = 24.dp)
        )

        StepperView(initialValue = 0)
    }
}