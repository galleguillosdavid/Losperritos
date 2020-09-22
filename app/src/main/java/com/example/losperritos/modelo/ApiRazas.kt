package com.example.losperritos.modelo

import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiRazas {

    @GET("breeds/list")
    fun getDataFromRazas() : Call<List<ListaRazas>>

    @GET("breed/{razas}/images")
    suspend fun getImagesFromRazas(@Path("razas") mRazas:String) : Response<List<ImagenesRazas>>


}