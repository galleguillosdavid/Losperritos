// Este es Cliente base de datos, que administra una instancia de una  base de datos para
// agrupar todos estos elementostos(Entity,dao,database) y proporcionarnos un metodo de
// forma simple y poder accedes a estos metodos y asi utilizarlo en nuestras aplicaciones
package com.example.losperritos.modelo.Model.RoomC6m20.cDatabase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.losperritos.modelo.Model.RoomC6m20.bDao.RazasDao
import com.example.losperritos.modelo.Model.RoomC6m20.aEntity.ImagenesRazas
import com.example.losperritos.modelo.Model.RoomC6m20.aEntity.ListaRazas


private const val  DATA_BASE_NAME = "razas_db"
@Database(entities = [ListaRazas::class, ImagenesRazas::class],version = 1)
// si tengo mas de una entidad, se separan por coma, todas deben estar declaradas aca[lambda en forma de fichas]

abstract class RazaDataBase: RoomDatabase() {
    //En norma general la Esta clase debe ser Abstracta y heredar de RoomDatabase
    //las clases abstractas, no hay un objeto base da datos pero si puedo utilizar los metodos en su interior
    //Debe contener almenos un metodo abstracto que no tiene argumentopsy que retorne los @Dao
    //que hayamos implementado
    // esta construcciono tiene las practicas necesarias para un correcto funcionamiento

    abstract fun getRazasDao(): RazasDao

    companion object {
        @Volatile
        private var INSTANCE: RazaDataBase? = null

        fun getDataBase(context: Context): RazaDataBase {
            val razasInstance = INSTANCE
            if (razasInstance != null) {
                return razasInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(context,
                    RazaDataBase::class.java,
                    DATA_BASE_NAME
                )
                    .build()
                    INSTANCE =instance
                return  instance
            }
        }
    }
}
