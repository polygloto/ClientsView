package com.mikhailovalx.clientsview.di

import com.mikhailovalx.clientsview.domain.use_case.GetClientsUseCase
import com.mikhailovalx.clientsview.domain.use_case.IGetClientsUseCase
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
}