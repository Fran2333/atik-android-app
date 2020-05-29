package com.pdm.atikapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView

class CategoryAdapter(
    private val context: Context,
    private val title: ArrayList<String>,
    private val description: ArrayList<String>,
    private val price: ArrayList<Double>
) : RecyclerView.Adapter<CategoryAdapter.ViewHolder>() {

    inner class ViewHolder (listItem: View) : RecyclerView.ViewHolder(listItem) {
        val header = listItem.findViewById<TextView>(R.id.header)
        val textView = listItem.findViewById<TextView>(R.id.text)
        val info = listItem.findViewById<TextView>(R.id.price)
    }

    private val inflater: LayoutInflater =
        context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val listView = inflater.inflate(R.layout.list_element, parent, false)

        listView.setOnClickListener {
            it.findNavController().navigate(R.id.action_categoryFragment_to_personalizeOrder)
        }

        return ViewHolder(listView)
    }

    override fun getItemCount(): Int {
        return title.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.header.setText(title[position])
        holder.textView.setText(description[position])
        holder.info.setText(price[position].toString())
    }

}