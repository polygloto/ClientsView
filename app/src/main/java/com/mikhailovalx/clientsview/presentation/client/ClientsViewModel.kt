package com.mikhailovalx.clientsview.presentation.client

import androidx.lifecycle.viewModelScope
import com.mikhailovalx.clientsview.core.base.BaseViewModel
import com.mikhailovalx.clientsview.domain.use_case.IGetClientsUseCase
import com.mikhailovalx.clientsview.models.ui.ClientUi
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ClientsViewModel @Inject constructor(
    private val getClientsUseCase: IGetClientsUseCase
) : BaseViewModel<ClientsScreenState, ClientsScreenContract>(ClientsScreenState()) {

    override fun reduce(oldState: ClientsScreenState, event: ClientsScreenContract) {
        viewModelScope.launch {
            val newState = when (event) {
                is ClientsScreenContract.FetchEvent -> handleFetchEvent()
                is ClientsScreenContract.OnClientClickEvent -> handleOnClientClickEvent()
            }
            setState(newState)
        }
    }

    init {
        viewModelScope.launch {
            sendEvent(ClientsScreenContract.FetchEvent)
        }
    }

    private fun handleOnClientClickEvent(): ClientsScreenState {
        val newList = state.value.data.toMutableList()
        newList.add(
            ClientUi(
                name = "onClientClick",
                phone = "---",
                isImportant = false
            )
        )
        return ClientsScreenState(newList)
    }

    private suspend fun handleFetchEvent(): ClientsScreenState {
        val clients = getClientsUseCase()
        return ClientsScreenState(clients)
    }
}