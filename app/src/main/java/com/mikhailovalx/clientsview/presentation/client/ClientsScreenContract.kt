package com.mikhailovalx.clientsview.presentation.client

import com.mikhailovalx.clientsview.core.IEvent
import com.mikhailovalx.clientsview.core.IState
import com.mikhailovalx.clientsview.models.ui.ClientUi
import javax.annotation.concurrent.Immutable

@Immutable
sealed class ClientsScreenContract : IEvent {
    object FetchEvent : ClientsScreenContract()
    object OnClientClickEvent : ClientsScreenContract()
}

@Immutable
data class ClientsScreenState(
    val data: List<ClientUi> = emptyList()
) : IState