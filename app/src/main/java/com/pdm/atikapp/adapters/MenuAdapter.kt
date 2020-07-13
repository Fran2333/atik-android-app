
package com.pdm.atikapp

import android.content.Context
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.core.net.toUri
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.pdm.atikapp.databinding.FragmentMenuBinding
import kotlinx.android.synthetic.main.grid_element.view.*

class MenuAdapter(
    private val context: Context,
    private val id: ArrayList<Int>,
    private val image: ArrayList<String>,
    private val category: ArrayList<String>
): BaseAdapter() {
    private val inflater: LayoutInflater =
        context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    //1
    override fun getCount(): Int {
        return category.size
    }

    //2
    override fun getItem(position: Int): Any {
        return category[position]
    }

    //3
    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    fun bindImage(imgView: ImageView, imgUrl: String?) {
        imgUrl?.let {
            val imgUri = it.toUri().buildUpon().scheme("https").build()
            Glide
                .with(imgView.context)
                .load(imgUri)
                .into(imgView)

        }
    }

    override fun getView(position:Int, convertView: View?, parent: ViewGroup?):View{
        val view = inflater.inflate(R.layout.grid_element,null)
        val img: ImageView = view.findViewById(R.id.category_img)
        Glide.with(context).load(image[position]).into(img)
        val name: TextView = view.findViewById(R.id.category_name)
        name.setText(category[position])

        view.card.setOnClickListener {
            val bundle = bundleOf("category_id" to id[position], "category_name" to category[position])
            it.findNavController().navigate(R.id.action_menuFragment_to_categoryFragment, bundle)
        }



        return view

    }
}
