package com.mikhailovalx.clientsview.core

import kotlinx.coroutines.flow.Flow

interface IUseCase {

    interface In<in Input> : IUseCase {
        suspend operator fun invoke(params: Input)
    }

    interface Out<out Output> : IUseCase {
        suspend operator fun invoke(): Output
    }

    interface InOut<in Input, out Output> : IUseCase {
        suspend operator fun invoke(params: Input): Output
    }

    interface FlowOut<out Output> : IUseCase {
        operator fun invoke(): Flow<Output>
    }

    interface FlowInOut<in Input, out Output> : IUseCase {
        operator fun invoke(params: Input): Flow<Output>
    }
}