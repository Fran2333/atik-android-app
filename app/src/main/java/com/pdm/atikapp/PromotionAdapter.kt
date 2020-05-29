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
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_grid_element.view.*
import java.security.AccessControlContext

class PromotionAdapter(
    context: Context,
    private val image: Array<Int>,
    private val category: ArrayList<String>,
    private val desc : ArrayList<String>
): BaseAdapter() {

    private val inflater: LayoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
     private var press = false;
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view = inflater.inflate(R.layout.activity_grid_element,null)

        val img: ImageView = view.findViewById(R.id.promotion_img)
        img.setImageResource(image[position])
        val name: TextView = view.findViewById(R.id.promotion_name)
        name.setText(category[position])

        val des : TextView = view.findViewById(R.id.tv_description)
        des.text = desc[position]

        view.im_forward.setOnClickListener{

            if(press){
                it.im_forward.speed = -1f
                it.im_forward.playAnimation()
                press = false
            }else{
                it.im_forward.speed= 1f;
                it.im_forward.playAnimation()

                press= true
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