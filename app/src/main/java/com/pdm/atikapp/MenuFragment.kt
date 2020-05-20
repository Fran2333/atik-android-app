package com.pdm.atikapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridLayout
import android.widget.GridView
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

/**
 * A simple [Fragment] subclass.
 */
class MenuFragment : Fragment() {

    var nameArray = arrayListOf<String>(
        "Categoria 1",
        "Categoria 2",
        "Categoria 3",
        "Categoria 4",
        "Categoria 5",
        "Categoria 6"
    )

    var imageArray = arrayOf<Int>(
        R.drawable.ic_sweet,
        R.drawable.ic_jar,
        R.drawable.ic_cake,
        R.drawable.ic_cupcake,
        R.drawable.ic_bread,
        R.drawable.ic_glutenfree
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_menu, container, false)
        val toolbar = (activity as AppCompatActivity).findViewById<androidx.appcompat.widget.Toolbar>(R.id.toolbar)
        toolbar.title = "Menu"
        (activity as AppCompatActivity).setSupportActionBar(toolbar)

        var gv = view.findViewById<GridView>(R.id.mainGrid)

        val adapter = MenuAdapter(context!!, imageArray, nameArray)
        gv.adapter = adapter

        gv.numColumns = 2
        gv.horizontalSpacing = 15
        gv.verticalSpacing = 25
        gv.stretchMode = GridView.STRETCH_COLUMN_WIDTH

        return view
    }

}
