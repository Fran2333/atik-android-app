package com.pdm.atikapp.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import androidx.navigation.findNavController
import com.pdm.atikapp.R
import com.pdm.atikapp.entity.ActiveOrder
import kotlinx.android.synthetic.main.active_order_element.view.*

class ActiveOrderAdapter(
    private val context: Context,
    private val active: List<ActiveOrder>
) : BaseAdapter() {

    private val inflater: LayoutInflater =
        context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    //1
    override fun getCount(): Int {
        return active.size
    }

    //2
    override fun getItem(position: Int): Any {
        return active[position]
    }

    //3
    override fun getItemId(position: Int): Long {
        return position.toLong()
    }


    //4
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val rowView = inflater.inflate(R.layout.active_order_element, parent, false)
        val order: TextView = rowView.findViewById(R.id.order_id)
        order.setText(active[position].id)
        val order_state: TextView = rowView.findViewById(R.id.state)
        order_state.setText(active[position].state)
        val order_products: TextView = rowView.findViewById(R.id.items)
        order_products.setText(active[position].type)
        val order_date: TextView = rowView.findViewById(R.id.date)
        order_date.setText(active[position].deliveryDate.toString())

        rowView.activeOrderElement.setOnClickListener {
            it.findNavController().navigate(R.id.action_activeOrdersFragment_to_activeOrderDetailFragment)
        }

        return rowView
    }
}