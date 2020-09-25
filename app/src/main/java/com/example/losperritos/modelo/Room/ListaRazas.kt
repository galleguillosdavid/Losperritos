package com.example.losperritos.modelo.Room


import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "lista_razas_table")
data class ListaRazas(
    @PrimaryKey val razaid: String
)