package com.example.losperritos.modelo

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitRazas {
    companion object{
        private const val URL_BASE = "https://dog.ceo/api/"
        fun getRetrofitRazas() : ApiRazas{
            val mRetrofitRazas = Retrofit.Builder()
                .baseUrl(URL_BASE)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            return mRetrofitRazas.create(ApiRazas::class.java)
        }
    }
}