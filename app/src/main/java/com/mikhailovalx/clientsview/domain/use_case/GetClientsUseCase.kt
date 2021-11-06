package com.mikhailovalx.clientsview.domain.use_case

import com.mikhailovalx.clientsview.core.IUseCase
import com.mikhailovalx.clientsview.core.extensions.convertAll
import com.mikhailovalx.clientsview.data.repository.ClientRepository
import com.mikhailovalx.clientsview.data.repository.IClientRepository
import com.mikhailovalx.clientsview.models.client.ClientUi
import javax.inject.Inject

class GetClientsUseCase @Inject constructor(
    private val clientRepository: IClientRepository
) : IGetClientsUseCase {
    override suspend fun invoke(): List<ClientUi> {
        return clientRepository.getClients().convertAll()
    }
}

interface IGetClientsUseCase : IUseCase.Out<List<ClientUi>>