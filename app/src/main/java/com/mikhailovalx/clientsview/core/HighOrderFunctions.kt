package com.mikhailovalx.clientsview.core

fun <T> unsafeLazy(lazyInitializer: () -> T): Lazy<T> = lazy(LazyThreadSafetyMode.NONE) {
    lazyInitializer.invoke()
}