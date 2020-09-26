package com.example.losperritos.modelo.aModel.Retrofit

import com.example.losperritos.modelo.aModel.RoomC6m20.aEntity.local.ImagenesRazas
import com.example.losperritos.modelo.aModel.RoomC6m20.aEntity.Internet.ListaRazasInternet
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiRazas {

    @GET("breeds/list")
    fun getDataFromRazas() : Call<ListaRazasInternet>

    @GET("breed/{razas}/images")
    suspend fun getImagesFromRazas(@Path("razas") mRazas:String) : Call<ImagenesRazas>


}