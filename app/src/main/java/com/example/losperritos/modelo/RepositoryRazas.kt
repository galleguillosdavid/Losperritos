package com.example.losperritos.modelo

import android.util.Log
import com.example.losperritos.modelo.Retrofit.RetrofitRazas
import com.example.losperritos.modelo.Room.ListaRazas
import com.example.losperritos.modelo.Room.ListaRazasInternet
import com.example.losperritos.modelo.Room.RazasDao
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RepositoryRazas(private val razasDao: RazasDao) {
    private val serviceRetrofit = RetrofitRazas.getRetrofitRazas()
    val mLiveDataListRazas = razasDao.getAllRazasFromDB()
    val mLiveDataImagenesRazas = razasDao.getAllImagenesFromDB()

    fun obtainDataInternet(){
        serviceRetrofit.getDataFromRazas().enqueue(object : Callback<ListaRazasInternet> {
            override fun onResponse(
                call: Call<ListaRazasInternet>,
                response: Response<ListaRazasInternet>

            ) {
                Log.d("obtain", response.body()?.message.toString())
                CoroutineScope(Dispatchers.IO).launch { response.body()?.let { razasDao.insertAllRazas(converter(it.message)) } }
            }

            override fun onFailure(call: Call<ListaRazasInternet>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })
    }
    fun converter(list: List<String>): List<ListaRazas>{
        var listtadoDeRazas = mutableListOf<ListaRazas>()
        list.map {
          listtadoDeRazas.add(ListaRazas(it))
        }
        return listtadoDeRazas
    }
}