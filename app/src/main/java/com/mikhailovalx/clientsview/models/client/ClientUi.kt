package com.mikhailovalx.clientsview.models.client

import com.mikhailovalx.clientsview.core.IConvertibleTo
import com.mikhailovalx.clientsview.core.extensions.toStringDate

data class ClientUi(
    val id: Long? = null,
    val name: String,
    val phone: String,
    val birthday: Long,
    val comment: String,
    val skips: Int,
    val isImportant: Boolean
) : IConvertibleTo<ClientEntity> {

    val stringBirthday = birthday.toStringDate()

    override fun convertTo(): ClientEntity {
        return ClientEntity(
            id = id,
            name = name,
            phone = phone,
            isImportant = isImportant,
            skips = skips,
            birthday = birthday,
            comment = comment
        )
    }
}