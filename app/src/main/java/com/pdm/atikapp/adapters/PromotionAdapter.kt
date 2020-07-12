package com.pdm.atikapp.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.pdm.atikapp.R
import kotlinx.android.synthetic.main.activity_grid_element.*
import kotlinx.android.synthetic.main.activity_grid_element.view.*
import kotlinx.android.synthetic.main.grid_element.view.*

class PromotionAdapter(
    context: Context,
    private val category: ArrayList<String>,
    private val desc : ArrayList<String>
): BaseAdapter() {

    private val inflater: LayoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
     private var press = false;
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view = inflater.inflate(R.layout.activity_grid_element,null)


        val name: TextView = view.findViewById(R.id.header)
        name.setText(category[position])

        val des : TextView = view.findViewById(R.id.textDsc)
        des.text = desc[position]

        view.cardViewPromotion.setOnClickListener{
            if(view.expandableLayout.visibility == View.GONE){
                view.expandableLayout.visibility = View.VISIBLE
            }else{
                view.expandableLayout.visibility = View.GONE
            }
        }
        return view
    }

    override fun getItem(position: Int): Any {
       return category[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return category.size
    }



}