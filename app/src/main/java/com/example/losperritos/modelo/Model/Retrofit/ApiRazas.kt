package com.example.losperritos.modelo.Model.Retrofit

import com.example.losperritos.modelo.Model.Room.ImagenesRazas
import com.example.losperritos.modelo.Model.Room.ListaRazasInternet
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiRazas {

    @GET("breeds/list")
    fun getDataFromRazas() : Call<ListaRazasInternet>

    @GET("breed/{razas}/images")
    suspend fun getImagesFromRazas(@Path("razas") mRazas:String) : Call<ImagenesRazas>


}