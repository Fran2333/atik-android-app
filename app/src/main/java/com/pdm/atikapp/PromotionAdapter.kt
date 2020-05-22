package com.pdm.atikapp

import android.annotation.SuppressLint
import android.content.ClipDescription
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import java.security.AccessControlContext

class PromotionAdapter(
    context: Context,
    private val image: Array<Int>,
    private val category: ArrayList<String>,
    private val description: ArrayList<String>
): BaseAdapter() {

    private val inflater: LayoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view = inflater.inflate(R.layout.activity_grid_element,null)

        val img: ImageView = view.findViewById(R.id.promotion_img)
        img.setImageResource(image[position])

        val name: TextView = view.findViewById(R.id.promotion_name)
        name.setText(category[position])

        val desc: TextView = view.findViewById(R.id.descPromotion)
        desc.setText(description[position])

        return view
    }

    override fun getItem(position: Int): Any {
        return category[position] + description[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return category.size + description.size
    }



}