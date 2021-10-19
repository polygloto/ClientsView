package com.mikhailovalx.clientsview.core

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.Flow

abstract class BaseViewModel<T : IState, in E : IEvent> : ViewModel() {
    abstract val state: Flow<T>

    //abstract fun Reducer(initial: T) : BaseReducer<T, in E>
}