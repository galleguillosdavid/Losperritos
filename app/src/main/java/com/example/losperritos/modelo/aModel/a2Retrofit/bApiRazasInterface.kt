//Esta interface de Kotlin Verde, Data Acces Objet, nos proporciona los metodos CROD que nos dan acceso a los datos
package com.example.losperritos.modelo.aModel.a2Retrofit

import com.example.losperritos.modelo.aModel.a1RoomC6m20.aEntity.local.ImagenesRazas
import com.example.losperritos.modelo.aModel.a1RoomC6m20.aEntity.Internet.ListaRazasInternet
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface bApiRazasInterface {

    @GET("breeds/list")
    fun getDataFromRazas() : Call<ListaRazasInternet>

    @GET("breed/{razas}/images")
    suspend fun getImagesFromRazas(@Path("razas") mRazas:String) : Call<ImagenesRazas>


}