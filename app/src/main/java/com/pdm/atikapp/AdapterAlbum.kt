package com.pdm.atikapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class AdapterAlbum (var list: ArrayList<Album>): RecyclerView.Adapter<AdapterAlbum.ViewHolder>(){


    class ViewHolder(view: View): RecyclerView.ViewHolder(view){

        fun bindItems(data: Album){
            val title:TextView=itemView.findViewById(R.id.txtTitle)
            val content:TextView=itemView.findViewById(R.id.txtContent)
            val thumbnail:ImageView=itemView.findViewById(R.id.thumbnail)

            title.text=data.name
            content.text=data.contentOfPromotion

            Glide.with(itemView.context).load(data.thumbnail).into(thumbnail)

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
       val v = LayoutInflater.from(parent.context).inflate(R.layout.fragment_content_item, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItems(list[position])
    }
}