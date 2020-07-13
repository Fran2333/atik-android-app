package com.pdm.atikapp.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.pdm.atikapp.R
import com.pdm.atikapp.entity.promotions
import kotlinx.android.synthetic.main.activity_grid_element.view.*

class PromotionAdapter(
    private val context: Context,
    private val promociones: ArrayList<promotions>
) : BaseAdapter() {

    private val inflater: LayoutInflater =
        context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    override fun getItem(position: Int): Any {
        return promociones[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return promociones.size
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view = inflater.inflate(R.layout.activity_grid_element, null)


        val text: TextView = view.findViewById(R.id.promotionText)
        text.setText(promociones[position].name)

        val des: TextView = view.findViewById(R.id.textDsc)
        des.setText(promociones[position].description)


        view.cardViewPromotion.setOnClickListener {
            if (view.expandableLayout.visibility == View.GONE) {
                view.expandableLayout.visibility = View.VISIBLE
            } else {
                view.expandableLayout.visibility = View.GONE
            }
        }
        return view
    }


}