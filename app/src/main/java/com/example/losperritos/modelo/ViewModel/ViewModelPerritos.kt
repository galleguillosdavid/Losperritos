package com.example.losperritos.modelo.ViewModel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import com.example.losperritos.modelo.RepositoryRazas
import com.example.losperritos.modelo.Model.RoomC6m20.cDatabase.RazaDataBase


class ViewModelPerritos(application: Application): AndroidViewModel(application) {
    val repository2 : RepositoryRazas
    init {
        Log.d("init","Creacion ")
        val repositoryDao = RazaDataBase.getDataBase(application).getRazasDao()
        repository2 = RepositoryRazas(repositoryDao)
        repository2.obtainDataInternet()
    }
}