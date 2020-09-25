package com.example.losperritos.modelo.Room

import com.google.gson.annotations.SerializedName

data class ListaRazasInternet (

    @SerializedName("message")   val message: List<String>,
    @SerializedName("status")   val status: String
)