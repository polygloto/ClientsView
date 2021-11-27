package com.mikhailovalx.clientsview.data.local.database.dao

import androidx.room.*
import com.mikhailovalx.clientsview.models.client.ClientEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface IClientDao {
    @Query("SELECT * FROM client_table ORDER BY NAME")
    fun getClients(): Flow<List<ClientEntity>>

    @Query("SELECT * FROM client_table WHERE ID = :clientId")
    fun getClientFlow(clientId: Long): Flow<ClientEntity>

    @Query("SELECT * FROM client_table WHERE ID = :clientId")
    fun getClient(clientId: Long): ClientEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(client: ClientEntity)

    @Update
    suspend fun update(client: ClientEntity)

    @Delete
    suspend fun delete(client: ClientEntity)
}