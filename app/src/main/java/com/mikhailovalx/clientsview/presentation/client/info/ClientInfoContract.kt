package com.mikhailovalx.clientsview.presentation.client.info

import com.mikhailovalx.clientsview.core.IEvent
import com.mikhailovalx.clientsview.core.IState
import com.mikhailovalx.clientsview.models.client.ClientUi
import javax.annotation.concurrent.Immutable

@Immutable
sealed class ClientInfoEvent : IEvent {
    data class FetchEvent(val clientId: Long) : ClientInfoEvent()
    object DeleteClientEvent : ClientInfoEvent()
}

@Immutable
data class ClientInfoState(
    val client: ClientUi
) : IState {
    companion object {
        val initial = ClientInfoState(
            client = ClientUi(
                id = null,
                name = "",
                phone = "",
                birthday = 0L,
                comment = "",
                skips = 0,
                isImportant = false
            )
        )
    }
}