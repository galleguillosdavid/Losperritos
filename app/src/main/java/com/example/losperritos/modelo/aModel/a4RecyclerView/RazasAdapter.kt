//clase 9 m 1:00 aprox
package com.example.losperritos.modelo.aModel.a4RecyclerView

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.losperritos.R
import com.example.losperritos.modelo.aModel.a1RoomC6m20.aEntity.local.ListaRazas
import com.example.losperritos.modelo.aModel.a2Retrofit.aRazas
import kotlinx.android.synthetic.main.razas_item_list.view.*


// despues del paso 3 ya tengo un view holder para heredar , luego implementar 3 members
class RazasAdapter(val mPassTheData: PassTheData): RecyclerView.Adapter<RazasAdapter.RazasViewHolder>() {
//    4 heredar del view holder

    private var razasDataList = emptyList<aRazas>()
//    1  Genere una variable que soporta el listado vacio

    fun actualizarListaRazas(mListaRazas: List<aRazas>){
//    2  Esta funcion actualiza la lista

        razasDataList = mListaRazas

    }

    inner class  RazasViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener{
//    3  Esta es la clase view holder

        val nameOfRazas = itemView.tv1Razas
        val itemView = itemView.setOnClickListener{
            mPassTheData.PassTheRazas(razasDataList[adapterPosition])
        }

        override fun onClick(v: View?) {
            TODO("Not yet implemented")
        }
//        override fun onClick(v: View?) {
//            TODO("Not yet implemented")
//        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RazasViewHolder {
//        5
        var itemView = LayoutInflater.from(parent.context).inflate(R.layout.razas_item_list, parent,false)
        //        c8 m: 1:40 el parent es el view group donde se va a mostrar y el false es para no quede pegado el fondo

        return RazasViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: RazasViewHolder, position: Int) {
//        6
        var numberOneRazas : aRazas = razasDataList[position]
//        Creamos una variable que llenara todos los objetos en la posiocion especifica

    }

    override fun getItemCount()= razasDataList.size
//        7


}
interface PassTheData {
    fun PassTheRazas(mListaRazas: aRazas)
}


/*class RazasAdapter(val razasList: List<String>) :

  RecyclerView.Adapter<RazasAdapter.RazasViewHolder>() {
//    para que funcione le paso una representacion de mi listado y una clase interna llamada

   inner class RazasViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
//    esta clase interna es un view holder, que es un representacion del objeto
//      c9 m1:00
       val razasText = itemView.tv1Razas
//        uso synthetic para encontrar los elemntos de vista con itemView

   }

   override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RazasViewHolder {
//        c7 m:23 . Indica al sistema quie tiene que dibujar esta vista la cantidad de veces que
//   30     Esta funcion devuelve un RazasViewHolder definido en linea 140.
       val itemView =
           LayoutInflater.from(parent.context).inflate(R.layout.razas_item_list, parent, false)
//        clasico sistema

       return RazasViewHolder(itemView)
   }

   override fun onBindViewHolder(holder: RazasViewHolder, position: Int) {
//        c7 m:46, este metodo une los datos que vengan desde la lista, con nuestras vistas que le indicamos
       val mRazas = razasList[position]
        holder.razasText.text = mRazas.toString()

   }

   override fun getItemCount() = razasList.size
//    N°1 c7 m:20
//        override fun getItemCount(): Int {
//        return razasList.size
//        Esta funcion devuelve el tamaño de la lista de la linea 8 y asi poder repetirlas en el adapter
*/
