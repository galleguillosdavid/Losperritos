//los datos llegan del repositorio al view model

package com.example.losperritos.modelo.bViewModel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.losperritos.modelo.aModel.a1RoomC6m20.aEntity.local.ListaRazas
import com.example.losperritos.modelo.aModel.a3Repositoryes.RepositoryRazas
import com.example.losperritos.modelo.aModel.a1RoomC6m20.cDatabase.RazaDataBase


abstract class ViewModelPerritos(application: Application): AndroidViewModel(application) {
//    el view model esta por sobre los elemntos de las vistas c6,2 m 1:30, c9 m0:7
//    aqui le decimos cuando parte y vive hasta el final, este es para usar el contexto de aplicacion
//    asi que creo una variable de referencia
    
    private val repository : RepositoryRazas
//    debo traerme los datos del repositorio,
    abstract  val allPerritos : LiveData<List<ListaRazas>>
    //la lectura d datos se realiza aqui

//
    init {
        Log.d("init","Creacion ")
        val repositoryDao = RazaDataBase.getDataBase(application).getRazasDao()
        repository = RepositoryRazas(repositoryDao)
        repository.obtainDataInternet()
    }

//    Hasta aqui me comunico con el modelo
//    desde aqui me comunico con las vistas, es el metodo que pide que pases las cosas
    fun insertardatos(): LiveData<List<ListaRazas>> {
  return repository.mLiveDataListRazas
}
//    c6 m 1:43
}
