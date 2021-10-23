package com.mikhailovalx.clientsview.data.repository

import com.mikhailovalx.clientsview.data.local.source.IClientLocalDataSource
import javax.inject.Inject

class ClientRepository @Inject constructor(
    private val localDataSource: IClientLocalDataSource
) : IClientRepository {
    override suspend fun getClients() {

    }
}

interface IClientRepository {
    suspend fun getClients()
}