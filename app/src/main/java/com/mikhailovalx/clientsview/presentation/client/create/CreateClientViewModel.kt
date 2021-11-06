package com.mikhailovalx.clientsview.presentation.client.create

import com.mikhailovalx.clientsview.core.base.BaseViewModel
import com.mikhailovalx.clientsview.domain.use_case.ISaveClientUseCase
import com.mikhailovalx.clientsview.domain.use_case.SaveClientUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class CreateClientViewModel @Inject constructor(
    private val saveClientUseCase: ISaveClientUseCase
) : BaseViewModel<CreateClientState, CreateClientEvent>(){
    override val initialState: CreateClientState = CreateClientState.initial

    override fun reduce(oldState: CreateClientState, event: CreateClientEvent) {
        launchIoTryCatch {
            val newState = when (event) {
                is CreateClientEvent.FetchEvent -> handleFetchEvent(event.clientId, oldState)
                is CreateClientEvent.OnIndicatorClicked -> handleIndicatorClick(oldState)
                is CreateClientEvent.OnSaveEvent -> handleClientSave(oldState)
                is CreateClientEvent.NameChangedEvent -> {
                    oldState.copy(client = oldState.client.copy(name = event.name))
                }
                is CreateClientEvent.PhoneChangedEvent -> {
                    oldState.copy(client = oldState.client.copy(phone = event.phone))
                }
                is CreateClientEvent.BirthdayChangedEvent -> {
                    oldState.copy(client = oldState.client.copy(birthday = event.birthday))
                }
                is CreateClientEvent.CommentChangedEvent -> {
                    oldState.copy(client = oldState.client.copy(comment = event.comment))
                }
                is CreateClientEvent.SkipsChangedEvent -> {
                    oldState.copy(client = oldState.client.copy(skips = event.skips))
                }
            }
            setState(newState)
        }
    }

    private fun handleFetchEvent(clientId: Long?, oldState: CreateClientState): CreateClientState {
        return if (clientId == null) {
            oldState
        } else {
            oldState
        }
    }

    private fun handleIndicatorClick(oldState: CreateClientState): CreateClientState {
        val newIndicatorValue = !oldState.client.isImportant
        return oldState.copy(
            client = oldState.client.copy(isImportant = newIndicatorValue)
        )
    }

    private suspend fun handleClientSave(oldState: CreateClientState): CreateClientState {
        saveClientUseCase(params = oldState.client)
        return oldState.copy(isSaved = true)
    }
}
