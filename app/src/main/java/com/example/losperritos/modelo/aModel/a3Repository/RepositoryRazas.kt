package com.example.losperritos.modelo.aModel.a3Repository

import android.util.Log
import androidx.lifecycle.LiveData
import com.example.losperritos.modelo.aModel.a2Retrofit.RetrofitRazas
import com.example.losperritos.modelo.aModel.a1RoomC6m20.aEntity.local.ListaRazas
import com.example.losperritos.modelo.aModel.a1RoomC6m20.aEntity.Internet.ListaRazasInternet
import com.example.losperritos.modelo.aModel.a1RoomC6m20.aEntity.local.ImagenesRazas
import com.example.losperritos.modelo.aModel.a1RoomC6m20.bDao.RazasDao
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RepositoryRazas(private val razasDao: RazasDao) {
//    c6,2 m 1:22
    private val serviceRetrofit = RetrofitRazas.getRetrofitRazas()
    val mLiveDataListRazas: LiveData<List<ListaRazas>> = razasDao.getAllRazasFromDB()
//    Este es un listado de live data y viene de la base de datos

    val mLiveDataImagenesRazas: LiveData<List<ImagenesRazas>> = razasDao.getAllImagenesFromDB()

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