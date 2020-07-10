package com.pdm.atikapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.pdm.atikapp.databinding.FragmentMenuBinding
import com.pdm.atikapp.databinding.GridElementBinding
import com.pdm.atikapp.network.Category
import kotlinx.android.synthetic.main.grid_element.view.*

class MenuAdapter(
) : ListAdapter<Category, MenuAdapter.MenuViewHolder>(DiffCallback){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuAdapter.MenuViewHolder {
        return MenuViewHolder(GridElementBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: MenuAdapter.MenuViewHolder, position: Int) {
        val category = getItem(position)

        holder.bind(category)
    }

    companion object DiffCallback: DiffUtil.ItemCallback<Category>(){
        override fun areItemsTheSame(oldItem: Category, newItem: Category): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: Category, newItem: Category): Boolean {
            return oldItem.id == newItem.id
        }
    }

    class MenuViewHolder(
        private var binding: GridElementBinding
    ): RecyclerView.ViewHolder(binding.root){

        fun bind(category: Category){
            binding.category = category
            binding.executePendingBindings()
        }

    }

}
