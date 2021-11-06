package com.mikhailovalx.clientsview.domain.use_case

import com.mikhailovalx.clientsview.core.IUseCase
import javax.inject.Inject

class GetClientUseCase @Inject constructor() : IGetClientByIdUseCase {

    override suspend fun invoke(params: Long): String {
        return ""
    }
}

interface IGetClientByIdUseCase : IUseCase.InOut<Long, String>