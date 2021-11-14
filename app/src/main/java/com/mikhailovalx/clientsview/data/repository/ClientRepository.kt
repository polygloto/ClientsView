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

    override fun getClientById(clientId: Long): Flow<ClientEntity> {
        return localDataSource.getClientById(clientId)
    }
}

interface IClientRepository {
    fun getClients(): Flow<List<ClientEntity>>
    suspend fun saveClient(client: ClientEntity)
    fun getClientById(clientId: Long): Flow<ClientEntity>
}