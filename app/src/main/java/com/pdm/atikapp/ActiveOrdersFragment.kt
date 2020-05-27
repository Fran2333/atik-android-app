package com.pdm.atikapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

/**
 * A simple [Fragment] subclass.
 */
class ActiveOrdersFragment : Fragment() {

    var nameArray = arrayListOf<String>(
        "Orden Activa 1",
        "Orden Activa 2"
    )

    var stateArray = arrayListOf<String>(
        "Aceptada",
        "En proceso"
    )

    var productsArray = arrayListOf<String>(
        "Ver 1 producto",
        "Ver 8 productos"
    )

    var dateArray = arrayListOf<String>(
        "18 Abril 2020",
        "12 Mayo 2020"
    )



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_active_orders, container, false)

        val toolbar = (activity as AppCompatActivity).findViewById<androidx.appcompat.widget.Toolbar>(R.id.toolbar)
        toolbar.title = "Ordenes Activas"
        (activity as AppCompatActivity).setSupportActionBar(toolbar)
        (activity as AppCompatActivity).supportActionBar?.show()
        (activity as AppCompatActivity).supportActionBar?.setDisplayHomeAsUpEnabled(false)

        var lv = view.findViewById<ListView>(R.id.active_orders_list)

        val adapter = ActiveOrderAdapter(context!!, nameArray, stateArray, productsArray, dateArray)
        lv.adapter = adapter

        return view
    }

}
