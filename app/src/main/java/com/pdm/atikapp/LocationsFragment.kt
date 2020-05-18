package com.pdm.atikapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView


/**
 * A simple [Fragment] subclass.
 */
class LocationsFragment : Fragment() {
    var titleArray = arrayListOf<String>(
        "Ubicacion 1",
        "Ubicacion 2"
    )

    var descArray = arrayListOf<String>(
        "Descripcion 1",
        "Descripcion 2"
    )

    var imageArray = arrayOf<Int>(
        R.drawable.ic_signs,
        R.drawable.ic_signs
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        (activity as AppCompatActivity).supportActionBar?.title = "Ubicaciones"
        val view: View = inflater.inflate(R.layout.fragment_locations, container, false)

        var lv = view.findViewById<ListView>(R.id.locations_list)

        val adapter = LocationAdapter(context!!, titleArray, descArray, imageArray)
        lv.adapter = adapter

        return view
    }

}
