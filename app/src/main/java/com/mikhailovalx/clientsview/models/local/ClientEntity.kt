package com.mikhailovalx.clientsview.models.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "client_table") // TODO Rename table in migration, old name - client_list
data class ClientEntity(
    @PrimaryKey(autoGenerate = true) // TODO int -> long
    val id: Long,
    @ColumnInfo(name = "NAME") // TODO name,sec_name -> NAME
    val name: String,
    @ColumnInfo(name = "PHONE") // TODO number -> PHONE
    val phone: String,
    @ColumnInfo(name = "SPECIAL") // TODO to uppercase
    val special: Boolean,
    @ColumnInfo(name = "SKIPS") // TODO to uppercase
    val skips: Int,
    @ColumnInfo(name = "BIRTHDAY") // TODO to uppercase
    val birthday: String,
    @ColumnInfo(name = "COMMENT") // TODO to uppercase
    val comment: String
)