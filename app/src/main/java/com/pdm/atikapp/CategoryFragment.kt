package com.pdm.atikapp

import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView
import android.widget.Toolbar
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.fragment_category.*

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

        val image = view.findViewById<ImageView>(R.id.category_img)
        image.setImageResource(R.drawable.ingredientes)

        var lv = view.findViewById<ListView>(R.id.food_list)

        val adapter = CategoryAdapter(context!!, titleArray, descArray, precioArray)
        lv.adapter = adapter

        return view
    }


}
