package com.mikhailovalx.clientsview.presentation.client.list

import com.mikhailovalx.clientsview.core.IEvent
import com.mikhailovalx.clientsview.core.IState
import com.mikhailovalx.clientsview.models.client.ClientUi
import javax.annotation.concurrent.Immutable

@Immutable
sealed class ClientsScreenEvent : IEvent {
    object FetchEvent : ClientsScreenEvent()
    data class FindClientEvent(val searchQuery: String) : ClientsScreenEvent()
}

@Immutable
data class ClientsScreenState(
    val clients: List<ClientUi>
) : IState {
    companion object {
        val initial = ClientsScreenState(clients = emptyList())
    }
}