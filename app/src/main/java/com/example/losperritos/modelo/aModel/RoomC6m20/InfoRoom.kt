package com.example.losperritos.modelo.aModel.RoomC6m20

/*
Room es utlilizado para la persistencia de datos

https://developer.android.com/topic/libraries/architecture/room
dependencias de kotlin(kapt)

//dentro de dependencies {
  def room_version = "2.2.5"

  implementation "androidx.room:room-runtime:$room_version"
  kapt "androidx.room:room-compiler:$room_version"

  // optional - Kotlin Extensions and Coroutines support for Room
  implementation "androidx.room:room-ktx:$room_version"

  // optional - Test helpers
  testImplementation "androidx.room:room-testing:$room_version"
}
Dentyro de los pluging:      apply plugin: 'kotlin-kapt'

A) Entidad: Crea la tabla con todos sus atributos por columna
Mapea directamente a las tablas de mi base de datos, es mi representacion de la tabla que yo escriba en la base de datos
Pojo(java), Data class en Kotlin,


//@Entity, significa que es una entidad, table name: el nombre de la tabla
@Entity(tableName = "table_task")
//contruyo una clase Task (tarea)
data class Task (
// Defino los atributos
                @PrimaryKey(autoGenerate = true) @NotNull val id:Int=0,
                val NameOfItem: String,
                val Cuantity: Int=0,
                val Price: Int=0,
                val Subtotal: Int=0,
                val Total: Int=0
                )

B) Dao:
Es la Interfaz que declara un metodo, pero no los implementa por si sola, su objetivo es para interatuar con la base de datos, el dao Data acces Objet, es el acceso a los datos y es el crod: Crear, Leer, Actualizar y Borrar
anotacion

@Dao
interface TaskDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOneTask(mTask: Task)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMultipleTask(mTask: List<Task>)

    @Update
    suspend fun updateOneTask(mTask: Task)

    @Delete
    fun deleteOneTask(mTask: Task)

    //esta funcion esta envuelta en live data, y devolvera un listado envuelto en el
    @Query ("SELECT * FROM table_task")
    fun getAllTaskFromDb(): LiveData<List<Task>>

    //TRAE LOS DATOS POR ID
    @Query ("SELECT * FROM table_task WHERE id=:mId")
    fun getOneTaskByID(mId:Int): LiveData<Task>

    @Query("DELETE FROM table_task")
    suspend fun deleteAllTask()



C Database:

Este es Cliente base de datos,es un contenedor, que actua como unico punto de acceso a la base de datos
y administra una instancia de una  base de datos para  agrupar todos estos elementostos
(Entity,dao,database) y proporcionarnos un metodo de  forma simple para
 poder accedes a estos metodos y asi utilizarlo en nuestras aplicaciones

abstract fun getTaskDao(): TaskDao
companion object {
        @Volatile
        private var INSTANCE: TaskDatabase? = null
        fun getDatabase(context: Context): TaskDatabase {
            val tempInstace = INSTANCE
            if (tempInstace != null) {
                return tempInstace
            }
            synchronized(this) {
                val instance =
                    Room.databaseBuilder(context, TaskDatabase::class.java, DATA_BASE_NAME).build()
                INSTANCE = instance
                return instance
            }
        }
    }

Estructura para
1 tabla : 1 Entity, 1 Dao, 1 archivo database
2 tablas: 2 Entity, 2 Dao, 1 archivo database
3 tablas: 3 Entity, 3 Dao, 1 archivo database

patron fachada: utiliza una interfaz para construir su motor. muy utilizado en las bibliotecas y librerias
retrofit para traernos datos de internet.



se implementa con
la web oficial es
caracteristicas principales
se complementa con : retrofit, que trae datos de internet



 */