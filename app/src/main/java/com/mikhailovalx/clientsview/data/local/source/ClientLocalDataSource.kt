package com.mikhailovalx.clientsview.data.local.source

class ClientLocalDataSource() : IClientLocalDataSource {
    override suspend fun getClients() {

    }
}

interface IClientLocalDataSource {
    suspend fun getClients()
}