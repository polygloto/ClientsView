package com.mikhailovalx.clientsview.data.di

import com.mikhailovalx.clientsview.data.local.ClientLocalDataSource
import com.mikhailovalx.clientsview.data.local.IClientLocalDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
interface DataModule {

    @Binds
    @ViewModelScoped
    fun bindClientLocalDataSource(clientLocalDataSource: ClientLocalDataSource): IClientLocalDataSource
}