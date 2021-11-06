package com.mikhailovalx.clientsview.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.mikhailovalx.clientsview.data.local.database.dao.IClientDao
import com.mikhailovalx.clientsview.models.client.ClientEntity

@Database(entities = [ClientEntity::class], version = 1)
abstract class ClientsViewDatabase : RoomDatabase() {
    abstract fun clientDao(): IClientDao
}