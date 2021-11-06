package com.mikhailovalx.clientsview.data.local.database.dao

import androidx.room.*
import com.mikhailovalx.clientsview.models.client.ClientEntity

@Dao
interface IClientDao {
    @Query("SELECT * FROM client_table")
    suspend fun getClients(): List<ClientEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(client: ClientEntity)

    @Delete
    suspend fun delete(client: ClientEntity)
}