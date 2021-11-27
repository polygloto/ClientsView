package com.mikhailovalx.clientsview.presentation.client.info

import com.mikhailovalx.clientsview.core.base.BaseViewModel
import com.mikhailovalx.clientsview.domain.use_case.IDeleteClientUseCase
import com.mikhailovalx.clientsview.domain.use_case.IGetClientFlowUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import javax.inject.Inject

@HiltViewModel
class ClientInfoViewModel @Inject constructor(
    private val getClientUseCase: IGetClientFlowUseCase,
    private val deleteClientUseCase: IDeleteClientUseCase
) : BaseViewModel<ClientInfoState, ClientInfoEvent>() {
    override val initialState: ClientInfoState = ClientInfoState.initial

    override fun reduce(oldState: ClientInfoState, event: ClientInfoEvent) {
        launchIoTryCatch {
            when (event) {
                is ClientInfoEvent.FetchEvent -> handleFetchEvent(event.clientId)
                is ClientInfoEvent.DeleteClientEvent -> handleDeleteEvent(oldState)
            }
        }
    }

    private suspend fun handleFetchEvent(clientId: Long) {
        getClientUseCase(clientId).collect {
            setState(
                ClientInfoState(client = it)
            )
        }
    }

    private suspend fun handleDeleteEvent(oldState: ClientInfoState) {
        deleteClientUseCase(params = oldState.client)
    }
}