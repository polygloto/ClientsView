package com.mikhailovalx.clientsview.domain.use_case

import com.mikhailovalx.clientsview.core.IUseCase
import com.mikhailovalx.clientsview.models.ui.ClientUi
import javax.inject.Inject

class GetClientsUseCase @Inject constructor() : IGetClientsUseCase {
    override suspend fun invoke(): List<ClientUi> {
        return listOf(
            ClientUi(
                name = "Alexander",
                phone = "89214043219",
                isImportant = true
            ),
            ClientUi(
                name = "Viktoriya",
                phone = "89214043219",
                isImportant = false
            ),
            ClientUi(
                name = "Bob",
                phone = "89214043219",
                isImportant = true
            )
        )
    }
}

interface IGetClientsUseCase : IUseCase.Out<List<ClientUi>>