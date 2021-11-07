package com.mikhailovalx.clientsview.domain.use_case

import com.mikhailovalx.clientsview.core.IUseCase
import com.mikhailovalx.clientsview.core.extensions.convertAll
import com.mikhailovalx.clientsview.data.repository.IClientRepository
import com.mikhailovalx.clientsview.models.client.ClientUi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class GetClientsUseCase @Inject constructor(
    private val clientRepository: IClientRepository
) : IGetClientsUseCase {
    override fun invoke(): Flow<List<ClientUi>> {
        return clientRepository.getClients().map { it.convertAll() }
    }
}

interface IGetClientsUseCase : IUseCase.FlowOut<List<ClientUi>>