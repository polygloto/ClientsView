package com.mikhailovalx.clientsview.di

import android.content.Context
import androidx.room.Room
import com.mikhailovalx.clientsview.data.local.database.ClientsViewDatabase
import com.mikhailovalx.clientsview.data.local.database.dao.IClientDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RoomModule {

    @Provides
    @Singleton
    fun provideRoomDatabase(@ApplicationContext context: Context): ClientsViewDatabase {
        return Room.databaseBuilder(
            context.applicationContext,
            ClientsViewDatabase::class.java,
            "clients_view_db" // TODO migration from client_list_db to clients_view_db
        ).build()
    }

    @Provides
    @Singleton
    fun provideClientDao(database: ClientsViewDatabase): IClientDao = database.clientDao()
}