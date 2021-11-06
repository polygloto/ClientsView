package com.mikhailovalx.clientsview.core

interface IConvertible<in Input, out Output> {
    fun <Input> convert(): Output
}