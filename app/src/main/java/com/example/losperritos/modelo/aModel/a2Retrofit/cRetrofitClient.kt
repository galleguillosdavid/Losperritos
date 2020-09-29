// El objeto que llega de internet, autogenerado con postman
//clase 8 m3:00:00
package com.example.losperritos.modelo.aModel.a2Retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class cRetrofitClient {//solicita reques entre cliente y servidor
    companion object{
        private const val URL_BASE = "https://dog.ceo/api/"
        fun getRetrofitRazas() : bApiRazasInterface {
            val mRetrofitRazas = Retrofit.Builder()
                .baseUrl(URL_BASE)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            return mRetrofitRazas.create(bApiRazasInterface::class.java)
        }
    }
}