package com.example.losperritos.modelo


import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "lista_razas_table")
data class ListaRazas(
    @PrimaryKey val id: String,
    @SerializedName("message")   val message: List<String>,
    @SerializedName("status")   val status: String
)