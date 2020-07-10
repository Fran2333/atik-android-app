package com.pdm.atikapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView

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
        (activity as AppCompatActivity).supportActionBar?.show()
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back)
        toolbar.setNavigationOnClickListener { activity!!.onBackPressed() }
        (activity as AppCompatActivity).findViewById<BottomNavigationView>(R.id.bottomNavigationView).visibility = View.GONE

        var gv = view.findViewById<RecyclerView>(R.id.mainGrid)

        val adapter = MenuAdapter()
        gv.adapter = adapter

        return view
    }

}
