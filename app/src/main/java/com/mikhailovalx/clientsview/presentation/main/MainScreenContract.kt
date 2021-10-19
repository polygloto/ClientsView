package com.mikhailovalx.clientsview.presentation.main

import com.mikhailovalx.clientsview.core.IEvent
import com.mikhailovalx.clientsview.core.IState
import com.mikhailovalx.clientsview.models.ui.ClientUi
import javax.annotation.concurrent.Immutable

@Immutable
sealed class MainScreenContract : IEvent {
    data class FetchEvent(val clients: List<ClientUi>) : MainScreenContract()
}

@Immutable
data class MainScreenState(
    val data: List<ClientUi>
) : IState {
    companion object {
        fun initial() = MainScreenState(data = emptyList())
    }
}