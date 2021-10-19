package com.mikhailovalx.clientsview.data.di

import com.mikhailovalx.clientsview.data.repository.ClientRepository
import com.mikhailovalx.clientsview.data.repository.IClientRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
interface RepositoryModule {

    @Binds
    @ViewModelScoped
    fun bindClientRepository(repository: ClientRepository): IClientRepository
}