package com.mikhailovalx.clientsview.di

import com.mikhailovalx.clientsview.domain.use_case.*
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

    @Binds
    @ViewModelScoped
    fun bindFindClientUseCase(getClientUseCase: FindClientUseCase): IFindClientUseCase

    @Binds
    @ViewModelScoped
    fun bindMonthCalendarUseCase(getMonthCalendarUseCase: GetMonthCalendarUseCase): IGetMonthCalendarUseCase
}