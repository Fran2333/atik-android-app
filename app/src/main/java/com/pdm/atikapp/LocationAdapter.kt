package com.pdm.atikapp

import android.content.Context
import android.graphics.drawable.Drawable
import android.graphics.drawable.Icon
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class LocationAdapter (
    private val context: Context,
    private val title: ArrayList<String>,
    private val location: ArrayList<String>
    //private val image: Array<Int>
    ) : BaseAdapter() {

        private val inflater: LayoutInflater =
            context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

        //1
        override fun getCount(): Int {
            return title.size
        }

        //2
        override fun getItem(position: Int): Any {
            return title[position]
        }

        //3
        override fun getItemId(position: Int): Long {
            return position.toLong()
        }


        //4
        override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
            // Get view for row item
            val rowView = inflater.inflate(R.layout.location_list, parent, false)
            val header: TextView = rowView.findViewById(R.id.header)
            header.setText(title[position])
            val textView: TextView = rowView.findViewById(R.id.text)
            textView.setText(location[position])
            //val icon: ImageView = rowView.findViewById(R.id.locationIcon)
           // icon.setImageResource(image[position])

            return rowView
        }
}