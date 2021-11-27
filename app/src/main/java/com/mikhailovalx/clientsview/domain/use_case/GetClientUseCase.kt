package com.mikhailovalx.clientsview.domain.use_case

import com.mikhailovalx.clientsview.core.IUseCase
import com.mikhailovalx.clientsview.data.repository.IClientRepository
import com.mikhailovalx.clientsview.models.client.ClientUi
import javax.inject.Inject

class GetClientUseCase @Inject constructor(
    private val clientRepository: IClientRepository
) : IGetClientUseCase {
    override suspend fun invoke(params: Long): ClientUi {
        return clientRepository.getClient(clientId = params).convertTo()
    }
}

interface IGetClientUseCase : IUseCase.InOut<Long, ClientUi>