package com.mikhailovalx.clientsview.domain.use_case

import com.mikhailovalx.clientsview.core.IUseCase
import com.mikhailovalx.clientsview.core.extensions.convertAll
import com.mikhailovalx.clientsview.data.repository.IClientRepository
import com.mikhailovalx.clientsview.models.client.ClientUi
import javax.inject.Inject

class FindClientUseCase @Inject constructor(
    private val clientRepository: IClientRepository
) : IFindClientUseCase {
    override suspend fun invoke(params: String): List<ClientUi> {
        return clientRepository.findClient(searchQuery = params).convertAll()
    }
}

interface IFindClientUseCase : IUseCase.InOut<String, List<ClientUi>>