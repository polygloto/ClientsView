package com.mikhailovalx.clientsview.core

interface IUseCase {
    interface Out<out Output> : IUseCase {
        suspend operator fun invoke(): Output
    }

    interface OutWithParams<in Params, out Output> : IUseCase {
        suspend operator fun invoke(params: Params? = null): Output
    }
}