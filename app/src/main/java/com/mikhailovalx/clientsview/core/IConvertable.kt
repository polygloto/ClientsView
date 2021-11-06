package com.mikhailovalx.clientsview.core

import kotlin.reflect.KClass

interface IConvertible {
    fun <I : Any> convertAs(clazz: KClass<I>): I?
}

interface IConvertibleTo<out T> : IConvertible{
    fun convertTo(): T?

    @Suppress("UNCHECKED_CAST")
    override fun <I : Any> convertAs(clazz: KClass<I>): I? = convertTo() as? I
}

interface IConvertibleWithParams<out T, in R : Any?> {
    fun convertTo(param: R) : T?
}

inline fun <reified To : Any> IConvertible.convert(): To? {
    return convertAs(To::class)
}