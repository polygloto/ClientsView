package com.mikhailovalx.clientsview.data.local.source

import com.mikhailovalx.clientsview.data.local.database.dao.IClientDao
import com.mikhailovalx.clientsview.models.client.ClientEntity
import javax.inject.Inject

class ClientLocalDataSource @Inject constructor(
    private val clientDao: IClientDao
) : IClientLocalDataSource {
    override suspend fun getClients(): List<ClientEntity> {
        return clientDao.getClients()
    }

    override suspend fun saveClient(client: ClientEntity) {
        clientDao.insert(client)
    }
}

interface IClientLocalDataSource {
    suspend fun getClients(): List<ClientEntity>
    suspend fun saveClient(client: ClientEntity)
}