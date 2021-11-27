package com.mikhailovalx.clientsview.data.repository

import com.mikhailovalx.clientsview.data.local.source.IClientLocalDataSource
import com.mikhailovalx.clientsview.models.client.ClientEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ClientRepository @Inject constructor(
    private val localDataSource: IClientLocalDataSource
) : IClientRepository {

    override fun getClients(): Flow<List<ClientEntity>> {
        return localDataSource.getClients()
    }

    override suspend fun saveClient(client: ClientEntity) {
        localDataSource.saveClient(client)
    }

    override fun getClientFlow(clientId: Long): Flow<ClientEntity> {
        return localDataSource.getClientFlow(clientId)
    }

    override suspend fun getClient(clientId: Long): ClientEntity {
        return localDataSource.getClient(clientId = clientId)
    }

    override suspend fun deleteClient(client: ClientEntity) {
        localDataSource.deleteClient(client = client)
    }

    override suspend fun updateClient(client: ClientEntity) {
        localDataSource.updateClient(client = client)
    }
}

interface IClientRepository {
    fun getClients(): Flow<List<ClientEntity>>
    suspend fun saveClient(client: ClientEntity)
    suspend fun getClient(clientId: Long): ClientEntity
    fun getClientFlow(clientId: Long): Flow<ClientEntity>
    suspend fun deleteClient(client: ClientEntity)
    suspend fun updateClient(client: ClientEntity)
}