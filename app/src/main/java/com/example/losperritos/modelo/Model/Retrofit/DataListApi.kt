package com.example.losperritos.modelo.Model.Retrofit


import com.google.gson.annotations.SerializedName

data class DataListApi(
    @SerializedName("message")
    val message: List<String>,
    @SerializedName("status")
    val status: String
)