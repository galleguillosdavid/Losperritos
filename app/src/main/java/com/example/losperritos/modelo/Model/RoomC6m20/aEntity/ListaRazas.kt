//Esta Entidad es la representacion de la tabla que se escribe en la base de datos
package com.example.losperritos.modelo.Model.RoomC6m20.aEntity


import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "lista_razas_table")
data class ListaRazas(
    @PrimaryKey val razaid: String
)