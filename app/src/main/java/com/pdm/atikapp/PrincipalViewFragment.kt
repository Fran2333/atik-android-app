package com.pdm.atikapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.google.android.material.bottomnavigation.BottomNavigationView
import android.widget.GridView

class PrincipalViewFragment : Fragment() {

    var nameArray = arrayListOf<String>(
        "Menu",
        "Pedidos especiales",
        "Promociones"
    )

    var descriptionArrary = arrayListOf<String>(
        "Realiza tu pedido",
        "Personaliza tu orden",
        "Ofertas del dia"
    )

    var imageArray = arrayOf<Int>(
        R.raw.food,
        R.raw.pagelist,
        R.raw.paperbounce
    )


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_principal_view, container, false)

        val toolbar = (activity as AppCompatActivity).findViewById<Toolbar>(R.id.toolbar)
        (activity as AppCompatActivity).setSupportActionBar(toolbar)
        (activity as AppCompatActivity).supportActionBar?.title = "Atik"

        var gv = view.findViewById<GridView>(R.id.principalGrid)

        val adapter = PrincipalAdapter(context!!, imageArray, nameArray, descriptionArrary)
        gv.adapter = adapter

        gv.numColumns = 1
        gv.verticalSpacing = 25
        gv.stretchMode = GridView.STRETCH_COLUMN_WIDTH

        return view
    }

    override fun onResume() {
        super.onResume()
        (activity as AppCompatActivity).findViewById<BottomNavigationView>(R.id.bottomNavigationView).visibility =
            View.VISIBLE
    }

}
