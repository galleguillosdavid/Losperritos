//Esta interface de Kotlin Verde, Data Acces Objet, nos proporciona los metodos Crood que nos dan acceso a los datos
package com.example.losperritos.modelo.Model.RoomC6m20.bDao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.losperritos.modelo.Model.RoomC6m20.aEntity.ImagenesRazas
import com.example.losperritos.modelo.Model.RoomC6m20.aEntity.ListaRazas

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