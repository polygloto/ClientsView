package com.mikhailovalx.clientsview.core

import kotlinx.coroutines.flow.Flow

interface IUseCase {

    interface In<in Params> : IUseCase {
        suspend operator fun invoke(params: Params)
    }

    interface Out<out Output> : IUseCase {
        suspend operator fun invoke(): Output
    }

    interface InOut<in Params, out Output> : IUseCase {
        suspend operator fun invoke(params: Params): Output
    }

    interface FlowOut<out Output> : IUseCase {
        operator fun invoke(): Flow<Output>
    }
}