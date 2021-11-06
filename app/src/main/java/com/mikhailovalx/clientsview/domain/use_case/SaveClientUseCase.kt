package com.mikhailovalx.clientsview.domain.use_case

import com.mikhailovalx.clientsview.core.IUseCase
import com.mikhailovalx.clientsview.data.repository.IClientRepository
import com.mikhailovalx.clientsview.models.client.ClientEntity
import com.mikhailovalx.clientsview.models.client.ClientUi
import javax.inject.Inject

class SaveClientUseCase @Inject constructor(
    private val clientRepository: IClientRepository
) : ISaveClientUseCase {
    override suspend fun invoke(params: ClientUi) {
        clientRepository.saveClient(client = params.convertTo())
    }
}

interface ISaveClientUseCase : IUseCase.In<ClientUi>