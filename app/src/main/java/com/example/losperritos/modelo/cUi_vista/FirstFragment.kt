//en Mvvm, las vistas solo observan loo que pasa en el vie model para poder obtener los datos
//c9 m:26
package com.example.losperritos.modelo.cUi_vista

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.losperritos.R
import com.example.losperritos.modelo.bViewModel.ViewModelPerritos

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {
// 1 declaro variable del view model

     lateinit var mViewModel: ViewModelPerritos
//    una variable que se crea pero no se instancia,
//    especialmente usada para los fragmentos y ciclos de vida


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mViewModel = ViewModelProvider(this).get(ViewModelPerritos::class.java)
//        2 Asigno el view model a las vistas
//        le indicamos al fragmento cual es su view model,
//        el view model que usara el fragmento es la clase que se llama ViewModelPerritos
//        se puede realizar en cualquiera de estos 4:
//        1) onAttach
//        2) onCreate
//        3)On Create View
//        4) on Activitycreate
//        los ciclos de vida completos estan en https://drive.google.com/file/d/1pJCdpi5ZXW6cW3fkVRS7GRKYVkcnj0kD/view?usp=sharing

    }

    override fun onCreateView(
//

            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mViewModel.insertardatos().observe(viewLifecycleOwner, Observer {
//        3 observo la funcion que me retorna live data desde el view model
            Log.d("Vistas", it.toString())
        })
//      aqui necesito observar esto que esta pasando, uso la variable que declare, asigne y ahora utilizo
//        en el metodo que hace un llamada a la api y me devuelve live data
        view.findViewById<Button>(R.id.button_first).setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }
    }
}