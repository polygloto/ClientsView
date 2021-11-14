package com.mikhailovalx.clientsview.presentation.client.info

import com.mikhailovalx.clientsview.core.base.BaseViewModel
import com.mikhailovalx.clientsview.domain.use_case.IGetClientByIdUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import javax.inject.Inject

@HiltViewModel
class ClientInfoViewModel @Inject constructor(
    private val getClientUseCase: IGetClientByIdUseCase
) : BaseViewModel<ClientInfoState, ClientInfoEvent>() {
    override val initialState: ClientInfoState = ClientInfoState.initial

    override fun reduce(oldState: ClientInfoState, event: ClientInfoEvent) {
        launchIoTryCatch {
            when (event) {
                is ClientInfoEvent.FetchEvent -> handleFetchEvent(event.clientId)
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
}