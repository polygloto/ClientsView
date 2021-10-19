package com.mikhailovalx.clientsview.presentation.main

import androidx.lifecycle.viewModelScope
import com.mikhailovalx.clientsview.core.BaseReducer
import com.mikhailovalx.clientsview.core.BaseViewModel
import com.mikhailovalx.clientsview.domain.use_case.IGetClientsUseCase
import com.mikhailovalx.clientsview.models.ui.ClientUi
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    //private val getClientsUseCase: IGetClientsUseCase
) : BaseViewModel<MainScreenState, MainScreenContract>() {

    private val reducer = MainReducer(MainScreenState(emptyList()))
    override val state: Flow<MainScreenState> get() = reducer.state

    init {
        viewModelScope.launch {
            reducer.sendEvent(MainScreenContract.FetchEvent(emptyList()))
        }
    }

    class MainReducer(initial: MainScreenState) : BaseReducer<MainScreenState, MainScreenContract>(initial) {
        override fun reduce(oldState: MainScreenState, event: MainScreenContract) {
            when(event) {
                is MainScreenContract.FetchEvent -> handleFetchEvent()
            }
        }

        private fun handleFetchEvent() {
            CoroutineScope(Dispatchers.IO).launch {
                val clients = listOf(
                    ClientUi(
                        name = "Alexander",
                        phone = "89214043219",
                        isImportant = false
                    )
                )
                setState(MainScreenState(clients))
            }
        }
    }
}