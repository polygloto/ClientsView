package com.mikhailovalx.clientsview.core.extensions

import com.mikhailovalx.clientsview.core.IConvertibleTo
import com.mikhailovalx.clientsview.core.convert

inline fun <reified O : Any> List<IConvertibleTo<O>>.convertAll(): List<O> {
    return this.mapNotNull { it.convert() }
}