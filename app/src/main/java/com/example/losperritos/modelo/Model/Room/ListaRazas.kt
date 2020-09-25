package com.example.losperritos.modelo.Model.Room


import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "lista_razas_table")
data class ListaRazas(
    @PrimaryKey val razaid: String
)