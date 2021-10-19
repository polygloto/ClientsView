package com.mikhailovalx.clientsview.data.local

class ClientLocalDataSource() : IClientLocalDataSource {
    override suspend fun getClients() {

    }
}

interface IClientLocalDataSource {
    suspend fun getClients()
}