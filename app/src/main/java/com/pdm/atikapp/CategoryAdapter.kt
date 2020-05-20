package com.pdm.atikapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
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

    /*override fun getView(viewHolder: ViewHolder, position: Int, convertView: View?, parent: ViewGroup): View {
        // Get view for row item
        val rowView = inflater.inflate(R.layout.list_element, parent, false)
        viewHolder.header.setText(title[position])
        viewHolder.textView.setText(description[position])
        viewHolder.info.setText(price[position].toString())

        return rowView
    }*/

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        print("hello")
        val listView = inflater.inflate(R.layout.list_element, parent, false)
        // Return a new holder instance
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