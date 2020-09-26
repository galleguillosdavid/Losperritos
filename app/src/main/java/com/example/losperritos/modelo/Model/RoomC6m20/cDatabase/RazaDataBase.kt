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
    //Esta funcion abstracta hereda de la interfaz dao que he creado y no del objeto dao

    companion object {
    //el companion objet es un metodo estatico, donde no necesito tener una referencia del objeto
    //para utilizar el metodo que esta en su interior

        @Volatile
    // el @volatile, es una anotacion que va directamenta  virtual machine y le indica que muchos hilos pueden
    // ver esta instancia u objeto en la memoria
        private var INSTANCE: RazaDataBase? = null

        fun getDataBase(context: Context): RazaDataBase {
//            este metodo recibe un contexto y devuelve un RazaDataBase, que a su ves es un RoomDatabase

            val razasInstance = INSTANCE
//          esta es una variable temporal  de la instancia, que es la instancia de la libreria de roomdatabase

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
