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
        clientDao.insert(client)
    }

    override fun getClientById(clientId: Long): Flow<ClientEntity> {
        return clientDao.getClientById(clientId)
    }
}

interface IClientLocalDataSource {
    fun getClients(): Flow<List<ClientEntity>>
    suspend fun saveClient(client: ClientEntity)
    fun getClientById(clientId: Long): Flow<ClientEntity>
}