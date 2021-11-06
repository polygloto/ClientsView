package com.mikhailovalx.clientsview.core.extensions

import com.mikhailovalx.clientsview.core.IConvertible

inline fun <reified I : Any, reified O : Any> List<IConvertible<I, O>>.convertAll(): List<O> {
    return this.map { it.convert<O>() }
}