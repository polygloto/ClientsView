package com.mikhailovalx.clientsview.presentation

import com.mikhailovalx.clientsview.models.client.ClientUi

object PresentationMocks {
    val client = ClientUi(
        name = "Alexander Mikhailov",
        phone = "89214043219",
        isImportant = true,
        birthday = 0L,
        comment = "222",
        skips = 2
    )
}