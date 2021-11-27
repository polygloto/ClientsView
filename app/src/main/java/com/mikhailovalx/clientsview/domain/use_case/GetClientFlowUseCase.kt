package com.mikhailovalx.clientsview.domain.use_case

import com.mikhailovalx.clientsview.core.IUseCase
import com.mikhailovalx.clientsview.data.repository.IClientRepository
import com.mikhailovalx.clientsview.models.client.ClientUi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class GetClientFlowUseCase @Inject constructor(
    private val clientRepository: IClientRepository
) : IGetClientFlowUseCase {
    override fun invoke(params: Long): Flow<ClientUi> {
        return clientRepository.getClientFlow(clientId = params).map {
            it.convertTo()
        }
    }
}

interface IGetClientFlowUseCase : IUseCase.FlowInOut<Long, ClientUi>