package com.mikhailovalx.clientsview.models.client

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.mikhailovalx.clientsview.core.IConvertibleTo

@Entity(tableName = "client_table") // TODO Rename table in migration, old name - client_list
data class ClientEntity(
    @PrimaryKey(autoGenerate = true) // TODO int -> long
    val id: Long?,
    @ColumnInfo(name = "NAME") // TODO name,sec_name -> NAME
    val name: String,
    @ColumnInfo(name = "PHONE") // TODO number -> PHONE
    val phone: String,
    @ColumnInfo(name = "IS_IMPORTANT") // TODO special -> IS_IMPORTANT
    val isImportant: Boolean,
    @ColumnInfo(name = "SKIPS") // TODO to uppercase
    val skips: Int,
    @ColumnInfo(name = "BIRTHDAY") // TODO to uppercase and type to LONG
    val birthday: Long,
    @ColumnInfo(name = "COMMENT") // TODO to uppercase
    val comment: String
) : IConvertibleTo<ClientUi> {
    override fun convertTo(): ClientUi {
        return ClientUi(
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