package com.mikhailovalx.clientsview.domain.use_case

import com.mikhailovalx.clientsview.core.IUseCase
import com.mikhailovalx.clientsview.data.repository.IClientRepository
import com.mikhailovalx.clientsview.models.client.ClientUi
import javax.inject.Inject

class SaveClientUseCase @Inject constructor(
    private val clientRepository: IClientRepository
) : ISaveClientUseCase {
    override suspend fun invoke(params: ClientUi) {
        if (params.id == null) {
            clientRepository.saveClient(client = params.convertTo())
        } else {
            clientRepository.updateClient(client = params.convertTo())
        }
    }
}

interface ISaveClientUseCase : IUseCase.In<ClientUi>