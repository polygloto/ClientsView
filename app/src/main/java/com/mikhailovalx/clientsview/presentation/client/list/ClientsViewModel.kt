package com.mikhailovalx.clientsview.presentation.client.list

import androidx.lifecycle.viewModelScope
import com.mikhailovalx.clientsview.core.base.BaseViewModel
import com.mikhailovalx.clientsview.domain.use_case.IGetClientsUseCase
import com.mikhailovalx.clientsview.models.client.ClientUi
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
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
                is ClientsScreenEvent.FetchEvent -> handleFetchEvent(event.clients)
            }
            setState(newState)
        }
    }

    init {
        collectClients()
    }

    private fun collectClients() {
        viewModelScope.launch {
            getClientsUseCase().collect {
                sendEvent(ClientsScreenEvent.FetchEvent(it))
            }
        }
    }

    private fun handleFetchEvent(clients: List<ClientUi>): ClientsScreenState {
        return ClientsScreenState(clients)
    }
}