package com.pdm.atikapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

/**
 * A simple [Fragment] subclass.
 */
class ActiveOrderDetailFragment : Fragment() {
    var titleArray = arrayListOf<String>(
        "Producto 1", "Producto 2", "Producto 3", "Producto 4",
        "Producto 5", "Producto 6", "Producto 7"
    )

    var descArray = arrayListOf<String>(
        "Descripcion 1",
        "Descripcion 2",
        "Descripcion 3",
        "Descripcion 4",
        "Descripcion 5",
        "Descripcion 6",
        "Descripcion 7"
    )

    var precioArray = arrayListOf<Double>(
        11.00, 12.00, 13.00, 14.00,
        15.00, 16.00, 17.00
    )

    var subtotal = precioArray.sum()
    var shipping_price = 2.00
    var total = subtotal + shipping_price

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_active_order_detail, container, false)
        val toolbar = (activity as AppCompatActivity).findViewById<androidx.appcompat.widget.Toolbar>(R.id.toolbar)
        toolbar.title = "Orden Activa"
        (activity as AppCompatActivity).setSupportActionBar(toolbar)
        toolbar.setNavigationOnClickListener { activity!!.onBackPressed() }
        val label: TextView = view.findViewById(R.id.current_order_label)
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back)

        var lv = view.findViewById<ListView>(R.id.order_list)

        val adapter = OrderAdapter(context!!, titleArray, descArray, precioArray)
        lv.adapter = adapter

        var st = view.findViewById<TextView>(R.id.subtotal)
        st.setText(subtotal.toString())

        var sh = view.findViewById<TextView>(R.id.shipping)
        sh.setText(shipping_price.toString())

        var tp = view.findViewById<TextView>(R.id.total)
        tp.setText(total.toString())

        return view
    }

}
