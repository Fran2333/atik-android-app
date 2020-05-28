package com.pdm.atikapp

import android.content.Context
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import androidx.navigation.findNavController
import com.airbnb.lottie.LottieAnimationView
import kotlinx.android.synthetic.main.principal_element.view.*

/**
 * A simple [Fragment] subclass.
 */
class PrincipalAdapter(
    private val context: Context,
    private val animation: Array<Int>,
    private val name: ArrayList<String>,
    private val subtitle: ArrayList<String>
) : BaseAdapter() {
    private val inflater: LayoutInflater =
        context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    override fun getCount(): Int {
        return name.size
    }

    override fun getItem(position: Int): Any {
        return name[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view = inflater.inflate(R.layout.principal_element, null)

        val img: LottieAnimationView = view.findViewById(R.id.animation)
        img.setImageResource(animation[position])
        val title: TextView = view.findViewById(R.id.name)
        title.setText(name[position])
        val sub: TextView = view.findViewById(R.id.description)
        sub.setText(subtitle[position])

        view.principalCard.setOnClickListener {
            if (name[position] == "Menu")
                it.findNavController().navigate(R.id.action_principalViewFragment_to_menuFragment)
            else if (name[position] == "Pedidos especiales")
                it.findNavController()
                    .navigate(R.id.action_principalViewFragment_to_specialOrdersFragment)
            else if (name[position] == "Promociones")
                it.findNavController()
                    .navigate(R.id.action_principalViewFragment_to_promotionFragment)
        }

        return view

    }
}