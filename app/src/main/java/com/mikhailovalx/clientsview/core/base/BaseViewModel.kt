package com.mikhailovalx.clientsview.core.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mikhailovalx.clientsview.core.unsafeLazy
import com.mikhailovalx.clientsview.core.IEvent
import com.mikhailovalx.clientsview.core.IState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

abstract class BaseViewModel<S : IState, in E : IEvent> : ViewModel() {
    private val _state: MutableStateFlow<S> by unsafeLazy { MutableStateFlow(initialState) }
    abstract val initialState: S

    val state: StateFlow<S>
        get() = _state.asStateFlow()

    fun sendEvent(event: E) {
        reduce(_state.value, event)
    }

    fun setState(newState: S) {
        _state.value = newState
    }

    abstract fun reduce(oldState: S, event: E)

    protected fun launchIoTryCatch(suspendLambda: suspend () -> Unit) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                suspendLambda.invoke()
            } catch (ex: Exception) {
                ex.printStackTrace()
            }
        }
    }
}