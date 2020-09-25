package com.example.losperritos.modelo.Room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.losperritos.modelo.Room.ListaRazas


private const val  DATA_BASE_NAME = "razas_db"
@Database(entities = [ListaRazas::class, ImagenesRazas::class],version = 1)

abstract class RazaDataBase: RoomDatabase() {

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
