//Esta Entidad es la representacion de la tabla que se escribe en la base de datos
package com.example.losperritos.modelo.Model.RoomC6m20.aEntity

import com.google.gson.annotations.SerializedName

data class ListaRazasInternet (

    @SerializedName("message")   val message: List<String>,
    @SerializedName("status")   val status: String
)