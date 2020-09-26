//Esta interface de Kotlin Verde, Data Acces Objet, nos proporciona los metodos CROD que nos dan acceso a los datos
// solamenta al crear la anotacion @dato al principio, esta clase se convierte a interface
// Esta interface solo declara metodos, pero no seimplementan,
// Para declarar metodos, se hace declarando un nombre al metodo, lo que puede recibir y lo que devuelve C6 m53
// la creacion del primer dao interface esta en C6 m25

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
    //este metodo@insert(si hay conflictos = la estrategia. es reemplazar , Create: Crood

    suspend fun insertAllRazas(mListaRazas: List<ListaRazas>)
    // el atributo o palabra reservada suspend se utiliza para trabajo asincrono y es parte de corrutinas
    // Esta funcion insertAllRazas (recive en mListaRazas un listado <de ListaRazas>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllImagesRazas(mImagenesRazas: List<ImagenesRazas>)
    // Aunque la estrategia para 2 tablas es: 2 Entity, 2 Dao, 1 archivo database
    // En este caso el metodo onconflict utiliza una funcion llamando al insertAllImagesRazas,
    // pero uzando (mImagenesRazas: List<ImagenesRazas>) a diferencia del anterior
    // estos metodos se utilizan solo al ser llamados desde otras lugares


    @Query("SELECT * FROM lista_razas_table")
    // cRod: Read
    fun getAllRazasFromDB():LiveData<List<ListaRazas>>

    @Query("SELECT * FROM lista_razas_table WHERE razaid=:mId")
    // cRod: Read
    fun obtainDataRazaFromDataBase(mId: String):LiveData<ListaRazas>

    @Query("SELECT * FROM imagenes_razas_table")
    // cRod: Read
    fun getAllImagenesFromDB():LiveData<List<ImagenesRazas>>

    @Query("SELECT * FROM imagenes_razas_table WHERE imagenesId=:mId")
    // cRod: Read
    fun obtainDataImagenesFromDataBase(mId: String):LiveData<ImagenesRazas>

}