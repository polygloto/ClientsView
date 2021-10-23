package com.mikhailovalx.clientsview.data.local.database.dao

import androidx.room.*
import com.mikhailovalx.clientsview.models.local.ClientEntity

@Dao
interface ClientDao {
    @Query("SELECT * FROM client_table")
    suspend fun getClients(): List<ClientEntity>

    @Insert
    suspend fun insert(client: ClientEntity)

    @Update
    suspend fun update(client: ClientEntity)

    @Delete
    suspend fun delete(client: ClientEntity)
}