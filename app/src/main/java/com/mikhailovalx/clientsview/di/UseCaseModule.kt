package com.mikhailovalx.clientsview.di

import com.mikhailovalx.clientsview.domain.use_case.*
import com.mikhailovalx.clientsview.domain.use_case.GetClientsUseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
interface UseCaseModule {

    @Binds
    @ViewModelScoped
    fun bindGetClientsUseCase(getClientsUseCase: GetClientsUseCase): IGetClientsUseCase

    @Binds
    @ViewModelScoped
    fun bindSaveClientUseCase(saveClientUseCase: SaveClientUseCase): ISaveClientUseCase

    @Binds
    @ViewModelScoped
    fun bindGetClientFlowUseCase(getClientFlowUseCase: GetClientFlowUseCase): IGetClientFlowUseCase

    @Binds
    @ViewModelScoped
    fun bindGetClientUseCase(getClientUseCase: GetClientUseCase): IGetClientUseCase

    @Binds
    @ViewModelScoped
    fun bindDeleteClientUseCase(getClientUseCase: DeleteClientUseCase): IDeleteClientUseCase
}