package com.mikhailovalx.clientsview.presentation.client.list

import androidx.lifecycle.viewModelScope
import com.mikhailovalx.clientsview.core.base.BaseViewModel
import com.mikhailovalx.clientsview.domain.use_case.IGetClientsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ClientsViewModel @Inject constructor(
    private val getClientsUseCase: IGetClientsUseCase
) : BaseViewModel<ClientsScreenState, ClientsScreenEvent>() {

    override val initialState: ClientsScreenState = ClientsScreenState.initial

    override fun reduce(oldState: ClientsScreenState, event: ClientsScreenEvent) {
        viewModelScope.launch {
            val newState = when (event) {
                is ClientsScreenEvent.FetchEvent -> handleFetchEvent()
                is ClientsScreenEvent.OnClientClickEvent -> handleOnClientClickEvent(oldState)
            }
            setState(newState)
        }
    }

    init {
        viewModelScope.launch {
            sendEvent(ClientsScreenEvent.FetchEvent)
        }
    }

    private fun handleOnClientClickEvent(oldState: ClientsScreenState): ClientsScreenState {
        return oldState
    }

    private suspend fun handleFetchEvent(): ClientsScreenState {
        val clients = getClientsUseCase()
        return ClientsScreenState(clients)
    }
}