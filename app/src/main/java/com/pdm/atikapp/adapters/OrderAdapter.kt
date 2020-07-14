package com.pdm.atikapp.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageButton
import android.widget.TextView
import com.pdm.atikapp.R
import com.pdm.atikapp.entity.CartItem

class OrderAdapter(
    private val context: Context,
    private val cartItems: List<CartItem>
) : BaseAdapter() {

    private val inflater: LayoutInflater =
        context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    //1
    override fun getCount(): Int {
        return cartItems.size
    }

    //2
    override fun getItem(position: Int): Any {
        return cartItems[position]
    }

    //3
    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    //4
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        // Get view for row item
        val rowView = inflater.inflate(R.layout.list_element, parent, false)
        val header: TextView = rowView.findViewById(R.id.header)
        header.setText(cartItems[position].product.name)
        val textView: TextView = rowView.findViewById(R.id.text)
        textView.setText(cartItems[position].product.description)
        val info: TextView = rowView.findViewById(R.id.price)
        val price_double = cartItems[position].product.price / 100
        info.setText("$ " + price_double.toString())
        val btn : ImageButton = rowView.findViewById(R.id.add_to_cart)
        btn.visibility = View.GONE

        return rowView
    }

}


