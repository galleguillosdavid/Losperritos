/*
c8 m3:19
la tarea principal de esta Clase Repository es ser la unica fuente confiable de datos para a que el view model pueda
tomar estos datosy exponerlos en las vistas c9m0:7
*/

package com.example.losperritos.modelo.aModel.a3Repositoryes

import android.util.Log
import androidx.lifecycle.LiveData
import com.example.losperritos.modelo.aModel.a2Retrofit.cRetrofitClient
import com.example.losperritos.modelo.aModel.a1RoomC6m20.aEntity.local.ListaRazas
import com.example.losperritos.modelo.aModel.a1RoomC6m20.aEntity.Internet.ListaRazasInternet
import com.example.losperritos.modelo.aModel.a1RoomC6m20.aEntity.local.ImagenesRazas
import com.example.losperritos.modelo.aModel.a1RoomC6m20.bDao.RazasDaoInterface
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RepositoryRazas(private val razasDao: RazasDaoInterface) {
    //    c6,2 m 1:22
    private val serviceRetrofit = cRetrofitClient.getRetrofitRazas()
    val mLiveDataListRazas: LiveData<List<ListaRazas>> = razasDao.getAllRazasFromDB()
//    Este es un listado de live data y viene de la base de datos

    val mLiveDataImagenesRazas: LiveData<List<ImagenesRazas>> = razasDao.getAllImagenesFromDB()

    //    la vieja confiable c8 m3:25
    fun obtainDataInternet() {
//
        serviceRetrofit.getDataFromRazas().enqueue(object : Callback<ListaRazasInternet> {
            override fun onResponse(
                call: Call<ListaRazasInternet>,
                response: Response<ListaRazasInternet>
            ) {
                Log.d("obtain", response.body()?.message.toString())
                when (response.code()) {
                    in 200..299 ->
                        CoroutineScope(Dispatchers.IO).launch {
                            response.body()?.let { razasDao.insertAllRazas(converter(it.message)) }
                        }
                    in 300..399 -> CoroutineScope(Dispatchers.IO).launch {
                        Log.d(
                            "Error 300",
                            response.errorBody().toString()
                        )
                    }
                    in 400..499 -> CoroutineScope(Dispatchers.IO).launch {
                        Log.d(
                            "Error 400",
                            response.errorBody().toString()
                        )
                    }
                }
            }

            override fun onFailure(call: Call<ListaRazasInternet>, t: Throwable) {
                CoroutineScope(Dispatchers.IO).launch { Log.e("Repository", t.message.toString()) }
            }
        })
    }

    fun converter(list: List<String>): List<ListaRazas> {
        var listtadoDeRazas = mutableListOf<ListaRazas>()
        list.map {
            listtadoDeRazas.add(ListaRazas(it))
        }
        return listtadoDeRazas
    }
}