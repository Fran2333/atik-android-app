package com.pdm.atikapp.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.pdm.atikapp.MainActivity
import com.pdm.atikapp.R
import com.pdm.atikapp.entity.CartItem
import com.pdm.atikapp.entity.Product
import com.pdm.atikapp.entity.ShoppingCart
import com.pdm.atikapp.fragments.CategoryFragment
import io.reactivex.Observable
import io.reactivex.ObservableOnSubscribe

class CategoryAdapter(
    private val context: Context,
    private val products: List<Product>
) : RecyclerView.Adapter<CategoryAdapter.ViewHolder>() {

    inner class ViewHolder(listItem: View) : RecyclerView.ViewHolder(listItem) {
        val quantity = listItem.findViewById<TextView>(R.id.quantity)
        val header = listItem.findViewById<TextView>(R.id.header)
        val textView = listItem.findViewById<TextView>(R.id.text)
        val info = listItem.findViewById<TextView>(R.id.price)
        val addToCart = listItem.findViewById<ImageButton>(R.id.add_to_cart)
        val remove = listItem.findViewById<ImageButton>(R.id.remove)
    }


    private val inflater: LayoutInflater =
        context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    override fun getItemId(position: Int): Long {
        return products[position].id.toLong()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val listView = inflater.inflate(R.layout.list_element, parent, false)


        return ViewHolder(listView)
    }

    override fun getItemCount(): Int {
        return products.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.quantity.visibility = View.GONE
        holder.header.setText(products[position].name)
        holder.textView.setText(products[position].description)
        val price_float: Double = products[position].price.toDouble() / 100
        holder.info.setText("$ " + price_float.toString())
        holder.remove.visibility = View.GONE
        
        holder.addToCart.setOnClickListener { view ->

            val item = CartItem(products[position])

            ShoppingCart.addItem(item)

            Toast.makeText(
                context,
                "${products[position].name} agregado a tu orden",
                Toast.LENGTH_LONG
            ).show()


        }


    }

}