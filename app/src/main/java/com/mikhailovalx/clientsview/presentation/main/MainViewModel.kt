package com.mikhailovalx.clientsview.presentation.main

import androidx.lifecycle.viewModelScope
import com.mikhailovalx.clientsview.core.base.BaseViewModel
import com.mikhailovalx.clientsview.domain.use_case.IGetClientsUseCase
import com.mikhailovalx.clientsview.models.ui.ClientUi
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getClientsUseCase: IGetClientsUseCase
) : BaseViewModel<MainScreenState, MainScreenContract>(MainScreenState()) {

    override fun reduce(oldState: MainScreenState, event: MainScreenContract) {
        viewModelScope.launch {
            val newState = when (event) {
                is MainScreenContract.FetchEvent -> handleFetchEvent()
                is MainScreenContract.OnClientClickEvent -> handleOnClientClickEvent()
            }
            setState(newState)
        }
    }

    init {
        viewModelScope.launch {
            sendEvent(MainScreenContract.FetchEvent)
        }
    }

    private fun handleOnClientClickEvent(): MainScreenState {
        val newList = state.value.data.toMutableList()
        newList.add(
            ClientUi(
                name = "onClientClick",
                phone = "---",
                isImportant = false
            )
        )
        return MainScreenState(newList)
    }

    private suspend fun handleFetchEvent(): MainScreenState {
        val clients = getClientsUseCase()
        return MainScreenState(clients)
    }
}