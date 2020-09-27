package com.example.losperritos.modelo.aModel.a4RecyclerView

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.razas_item_list.view.*

class RazasAdapter(val List: List<String>):RecyclerView.Adapter<RazasAdapter.RazasViewHolder>() {
//    para que funcione le paso una representacion de mi listado y una clase interna llamada

    inner class RazasViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
//    esta clase interna es un view holder, que es un representacion del objeto

        val razasText = itemView.tv1Razas
//        uso synthetic para encontrar los elemntos de vista con itemView

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RazasViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: RazasViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }
}