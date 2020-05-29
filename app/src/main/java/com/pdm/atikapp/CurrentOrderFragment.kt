package com.pdm.atikapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import kotlinx.android.synthetic.main.fragment_current_order.*
import kotlinx.android.synthetic.main.fragment_current_order.view.*

/**
 * A simple [Fragment] subclass.
 */
class CurrentOrderFragment : Fragment() {
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

    var subtotal = precioArray.sum()
    var shipping_price = 2.00
    var total = subtotal + shipping_price

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_current_order, container, false)
        val toolbar = (activity as AppCompatActivity).findViewById<androidx.appcompat.widget.Toolbar>(R.id.toolbar)
        toolbar.title = "Orden Actual"
        (activity as AppCompatActivity).setSupportActionBar(toolbar)
        (activity as AppCompatActivity).supportActionBar?.show()
        (activity as AppCompatActivity).supportActionBar?.setDisplayHomeAsUpEnabled(false)

        val label: TextView = view.findViewById(R.id.current_order_label)
        label.setText("${titleArray.size.toString()} productos en tu orden");

        var lv = view.findViewById<ListView>(R.id.order_list)

        val adapter = OrderAdapter(context!!, titleArray, descArray, precioArray)
        lv.adapter = adapter

        var st = view.findViewById<TextView>(R.id.subtotal)
        st.setText(subtotal.toString())

        var sh = view.findViewById<TextView>(R.id.shipping)
        sh.setText(shipping_price.toString())

        var tp = view.findViewById<TextView>(R.id.total)
        tp.setText(total.toString())

        val completeBtn = view.findViewById<Button>(R.id.complete_btn)

        completeBtn.setOnClickListener {
            it.findNavController().navigate(R.id.action_currentOrderFragment_to_fragmentCompleteOrder)
        }

        return view
    }

}
