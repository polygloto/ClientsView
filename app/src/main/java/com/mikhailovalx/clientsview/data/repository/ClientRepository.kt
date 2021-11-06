package com.mikhailovalx.clientsview.data.repository

import com.mikhailovalx.clientsview.data.local.source.IClientLocalDataSource
import com.mikhailovalx.clientsview.models.client.ClientEntity
import javax.inject.Inject

class ClientRepository @Inject constructor(
    private val localDataSource: IClientLocalDataSource
) : IClientRepository {

    override suspend fun getClients(): List<ClientEntity> {
        return localDataSource.getClients()
    }

    override suspend fun saveClient(client: ClientEntity) {
        localDataSource.saveClient(client)
    }
}

interface IClientRepository {
    suspend fun getClients(): List<ClientEntity>
    suspend fun saveClient(client: ClientEntity)
}