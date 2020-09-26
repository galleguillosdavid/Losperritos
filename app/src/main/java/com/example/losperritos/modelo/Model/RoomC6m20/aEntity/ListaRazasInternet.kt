//Esta Entidad es la representacion de la tabla que se escribe en la base de datos
//La entidad se define al escribir @Entity y es parte de room
//las aotaciones prinicpales de room @PrimaryKey(autoGenerate = true) ,@NonNull,
// @ColumnInfo= Sobrenombre con el que se guarda en la base de datos
// Para acceder al crod de esta entidad(tabla) lo hacemos con la interface  b) Dao
package com.example.losperritos.modelo.Model.RoomC6m20.aEntity

import com.google.gson.annotations.SerializedName

data class ListaRazasInternet (

    @SerializedName("message")   val message: List<String>,
    @SerializedName("status")   val status: String
)