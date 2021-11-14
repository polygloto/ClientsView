package com.mikhailovalx.clientsview.domain.use_case

import com.mikhailovalx.clientsview.core.IUseCase
import com.mikhailovalx.clientsview.data.repository.IClientRepository
import com.mikhailovalx.clientsview.models.client.ClientUi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class GetClientByIdUseCase @Inject constructor(
    private val clientRepository: IClientRepository
) : IGetClientByIdUseCase {
    override fun invoke(params: Long): Flow<ClientUi> {
        return clientRepository.getClientById(clientId = params).map {
            it.convertTo()
        }
    }
}

interface IGetClientByIdUseCase : IUseCase.FlowInOut<Long, ClientUi>