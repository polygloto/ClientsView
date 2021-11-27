package com.mikhailovalx.clientsview.data.local.source

import com.mikhailovalx.clientsview.data.local.database.dao.IClientDao
import com.mikhailovalx.clientsview.models.client.ClientEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ClientLocalDataSource @Inject constructor(
    private val clientDao: IClientDao
) : IClientLocalDataSource {

    override fun getClients(): Flow<List<ClientEntity>> {
        return clientDao.getClients()
    }

    override suspend fun saveClient(client: ClientEntity) {
        clientDao.insert(client = client)
    }

    override fun getClientFlow(clientId: Long): Flow<ClientEntity> {
        return clientDao.getClientFlow(clientId = clientId)
    }

    override suspend fun getClient(clientId: Long): ClientEntity {
        return clientDao.getClient(clientId = clientId)
    }

    override suspend fun deleteClient(client: ClientEntity) {
        clientDao.delete(client = client)
    }

    override suspend fun updateClient(client: ClientEntity) {
        clientDao.update(client = client)
    }
}

interface IClientLocalDataSource {
    fun getClients(): Flow<List<ClientEntity>>
    suspend fun saveClient(client: ClientEntity)
    suspend fun getClient(clientId: Long): ClientEntity
    fun getClientFlow(clientId: Long): Flow<ClientEntity>
    suspend fun deleteClient(client: ClientEntity)
    suspend fun updateClient(client: ClientEntity)
}