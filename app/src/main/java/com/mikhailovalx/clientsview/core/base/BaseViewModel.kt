package com.mikhailovalx.clientsview.core.base

import androidx.lifecycle.ViewModel
import com.mikhailovalx.clientsview.core.IEvent
import com.mikhailovalx.clientsview.core.IState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

abstract class BaseViewModel<S : IState, in E : IEvent>(defaultState: S) : ViewModel() {
    private val _state: MutableStateFlow<S> = MutableStateFlow(defaultState)

    val state: StateFlow<S>
        get() = _state

    fun sendEvent(event: E) {
        reduce(_state.value, event)
    }

    fun setState(newState: S) {
        _state.tryEmit(newState)
    }

    abstract fun reduce(oldState: S, event: E)
}