package com.mikhailovalx.clientsview.domain.use_case

import com.mikhailovalx.clientsview.core.IUseCase
import com.mikhailovalx.clientsview.data.repository.IClientRepository
import com.mikhailovalx.clientsview.models.client.ClientUi
import javax.inject.Inject

class DeleteClientUseCase @Inject constructor(
    private val clientRepository: IClientRepository
) : IDeleteClientUseCase {
    override suspend fun invoke(params: ClientUi) {
        clientRepository.deleteClient(client = params.convertTo())
    }
}

interface IDeleteClientUseCase : IUseCase.In<ClientUi>