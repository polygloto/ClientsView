package com.mikhailovalx.clientsview.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.mikhailovalx.clientsview.data.local.database.dao.ClientDao
import com.mikhailovalx.clientsview.models.local.ClientEntity

@Database(entities = [ClientEntity::class], version = 1)
abstract class ClientsViewDatabase : RoomDatabase() {
    abstract fun clientDao(): ClientDao
}