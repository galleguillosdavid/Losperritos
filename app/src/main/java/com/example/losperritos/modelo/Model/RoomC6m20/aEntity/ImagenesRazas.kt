//Esta Entidad es la representacion de la tabla que se escribe en la base de datos
package com.example.losperritos.modelo.Model.RoomC6m20.aEntity


import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "imagenes_razas_table")
data class ImagenesRazas( //pojo
    @PrimaryKey val imagenesId: String
//    @SerializedName("message")
//    val message: List<String>,
//    @SerializedName("status")
//    val status: String
)
