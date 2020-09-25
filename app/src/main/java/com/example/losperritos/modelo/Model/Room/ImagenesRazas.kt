package com.example.losperritos.modelo.Model.Room


import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "imagenes_razas_table")
data class ImagenesRazas(
    @PrimaryKey val imagenesId: String
//    @SerializedName("message")
//    val message: List<String>,
//    @SerializedName("status")
//    val status: String
)
