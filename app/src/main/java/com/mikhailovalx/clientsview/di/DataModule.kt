package com.mikhailovalx.clientsview.di

import com.mikhailovalx.clientsview.data.local.source.ClientLocalDataSource
import com.mikhailovalx.clientsview.data.local.source.IClientLocalDataSource
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