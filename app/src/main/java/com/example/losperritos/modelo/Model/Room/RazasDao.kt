package com.example.losperritos.modelo.Model.Room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface RazasDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllRazas(mListaRazas: List<ListaRazas>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllImagesRazas(mImagenesRazas: List<ImagenesRazas>)


    @Query("SELECT * FROM lista_razas_table")
    fun getAllRazasFromDB():LiveData<List<ListaRazas>>

    @Query("SELECT * FROM lista_razas_table WHERE razaid=:mId")
    fun obtainDataRazaFromDataBase(mId: String):LiveData<ListaRazas>

    @Query("SELECT * FROM imagenes_razas_table")
    fun getAllImagenesFromDB():LiveData<List<ImagenesRazas>>

    @Query("SELECT * FROM imagenes_razas_table WHERE imagenesId=:mId")
    fun obtainDataImagenesFromDataBase(mId: String):LiveData<ImagenesRazas>

}