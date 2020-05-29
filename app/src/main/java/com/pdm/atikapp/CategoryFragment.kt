package com.pdm.atikapp

import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.appbar.CollapsingToolbarLayout
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.fragment_category.*
import kotlinx.android.synthetic.main.fragment_category.view.*
import kotlinx.android.synthetic.main.fragment_category.view.cat_toolbar


/**
 * A simple [Fragment] subclass.
 */
class CategoryFragment : Fragment() {

    var titleArray = arrayListOf<String>(
        "Producto 1", "Producto 2", "Producto 3", "Producto 4",
        "Producto 5", "Producto 6", "Producto 7", "Producto 8"
    )

    var descArray = arrayListOf<String>(
        "Descripcion 1",
        "Descripcion 2",
        "Descripcion 3",
        "Descripcion 4",
        "Descripcion 5",
        "Descripcion 6",
        "Descripcion 7",
        "Descripcion 8"
    )

    var precioArray = arrayListOf<Double>(
        1.00, 2.00, 3.00, 4.00,
        5.00, 6.00, 7.00, 8.00
    )

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_category, container, false)

        val toolbar = (activity as AppCompatActivity).findViewById<Toolbar>(R.id.toolbar)
        (activity as AppCompatActivity).setSupportActionBar(toolbar)
        (activity as AppCompatActivity).supportActionBar?.hide()
        (activity as AppCompatActivity).findViewById<BottomNavigationView>(R.id.bottomNavigationView).visibility = View.GONE

        view.cat_toolbar.title = "Categoria"
        val category_toolbar = view.findViewById<Toolbar>(R.id.category_toolbar)
        (activity as AppCompatActivity).setSupportActionBar(category_toolbar)
        category_toolbar.setNavigationIcon(R.drawable.ic_arrow_back)
        category_toolbar.setNavigationOnClickListener { activity!!.onBackPressed() }

        var rv = view.findViewById<RecyclerView>(R.id.food_list)
        rv.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        val adapter = CategoryAdapter(context!!, titleArray, descArray, precioArray)
        rv.adapter = adapter

        return view
    }

}



