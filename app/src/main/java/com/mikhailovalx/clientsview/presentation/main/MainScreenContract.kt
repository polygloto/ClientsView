package com.mikhailovalx.clientsview.presentation.main

import com.mikhailovalx.clientsview.core.IEvent
import com.mikhailovalx.clientsview.core.IState
import com.mikhailovalx.clientsview.models.ui.ClientUi
import javax.annotation.concurrent.Immutable

@Immutable
sealed class MainScreenContract : IEvent {
    object FetchEvent : MainScreenContract()
    object OnClientClickEvent : MainScreenContract()
}

@Immutable
data class MainScreenState(
    val data: List<ClientUi> = emptyList()
) : IState