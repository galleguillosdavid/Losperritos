package com.example.losperritos.modelo.aModel.a4RecyclerView

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.losperritos.R
import kotlinx.android.synthetic.main.razas_item_list.view.*

class RazasAdapter(val razasList: List<String>) :
    RecyclerView.Adapter<RazasAdapter.RazasViewHolder>() {
//    para que funcione le paso una representacion de mi listado y una clase interna llamada

    inner class RazasViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
//    esta clase interna es un view holder, que es un representacion del objeto

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
}
