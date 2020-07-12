package com.pdm.atikapp.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.pdm.atikapp.R
import com.pdm.atikapp.entity.locations

class LocationAdapter (
    private val context: Context,
    private val ubicaciones : ArrayList<locations>
    ) : BaseAdapter() {

        private val inflater: LayoutInflater =
            context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

        //1
        override fun getCount(): Int {
            return ubicaciones.size
        }

        //2
        override fun getItem(position: Int): Any {
            return ubicaciones[position]
        }

        //3
        override fun getItemId(position: Int): Long {
            return position.toLong()
        }


        //4
        override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
            // Get view for row item
            val view = inflater.inflate(R.layout.location_list, null)
            val header: TextView = view.findViewById(R.id.header)
            header.setText(ubicaciones[position].name)
            val textView: TextView = view.findViewById(R.id.text)
            textView.setText(ubicaciones[position].address)


            return view
        }
}