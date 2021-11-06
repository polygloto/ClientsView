package com.mikhailovalx.clientsview.core

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

}