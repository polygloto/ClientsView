package com.mikhailovalx.clientsview.presentation.client.list

import com.mikhailovalx.clientsview.core.base.BaseViewModel
import com.mikhailovalx.clientsview.domain.use_case.IFindClientUseCase
import com.mikhailovalx.clientsview.domain.use_case.IGetClientsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import javax.inject.Inject

@HiltViewModel
class ClientsViewModel @Inject constructor(
    private val getClientsUseCase: IGetClientsUseCase,
    private val findClientsUseCase: IFindClientUseCase,
) : BaseViewModel<ClientsScreenState, ClientsScreenEvent>() {

    override val initialState: ClientsScreenState = ClientsScreenState.initial

    override fun reduce(oldState: ClientsScreenState, event: ClientsScreenEvent) {
        launchIoTryCatch {
            when (event) {
                is ClientsScreenEvent.FetchEvent -> handleFetchEvent()
                is ClientsScreenEvent.FindClientEvent -> handleFindClientEvent(event.searchQuery, oldState)
            }
        }
    }

    private suspend fun handleFetchEvent() {
        getClientsUseCase().collect {
            setState(ClientsScreenState(it))
        }
    }

    private suspend fun handleFindClientEvent(searchQuery: String, oldState: ClientsScreenState) {
        val clients = findClientsUseCase(params = searchQuery)
        val newState = oldState.copy(
            clients = clients
        )
        setState(newState)
    }
}