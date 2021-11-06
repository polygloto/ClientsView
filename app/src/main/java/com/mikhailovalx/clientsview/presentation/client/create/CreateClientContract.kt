package com.mikhailovalx.clientsview.presentation.client.create

import com.mikhailovalx.clientsview.core.IEvent
import com.mikhailovalx.clientsview.core.IState
import com.mikhailovalx.clientsview.models.client.ClientUi
import javax.annotation.concurrent.Immutable

@Immutable
sealed class CreateClientEvent : IEvent {
    data class FetchEvent(val clientId: Long?) : CreateClientEvent()
    data class NameChangedEvent(val name: String) : CreateClientEvent()
    data class PhoneChangedEvent(val phone: String) : CreateClientEvent()
    data class BirthdayChangedEvent(val birthday: Long) : CreateClientEvent()
    data class CommentChangedEvent(val comment: String) : CreateClientEvent()
    data class SkipsChangedEvent(val skips: Int) : CreateClientEvent()
    object OnSaveEvent : CreateClientEvent()
    object OnIndicatorClicked : CreateClientEvent()
}

@Immutable
data class CreateClientState(
    val client: ClientUi
) : IState {
    companion object {
        val initial = CreateClientState(
            client = ClientUi(
                id = null,
                name = "",
                phone = "",
                birthday = Long.MIN_VALUE,
                comment = "",
                skips = 0,
                isImportant = false
            )
        )
    }
}