package com.pdm.atikapp.fragments

import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.pdm.atikapp.R
import com.pdm.atikapp.adapters.CategoryAdapter
import com.pdm.atikapp.databinding.FragmentCategoryBinding
import com.pdm.atikapp.viewModels.CategoryViewModel


/**
 * A simple [Fragment] subclass.
 */
class CategoryFragment : Fragment() {
    private val categoryModel: CategoryViewModel by activityViewModels()


    var titleArray = arrayListOf<String>(
        "Producto 1", "Producto 2", "Producto 3", "Producto 4",
        "Producto 5", "Producto 6", "Producto 7", "Producto 8"
    )

    var descArray = arrayListOf<String>(
        "Descripcion 1",
        "Descripcion 2",
        "Descripcion 3",
        "Descripcion 4",
        "Descripcion 5",
        "Descripcion 6",
        "Descripcion 7",
        "Descripcion 8"
    )

    var precioArray = arrayListOf<Double>(
        1.00, 2.00, 3.00, 4.00,
        5.00, 6.00, 7.00, 8.00
    )

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        var result: Boolean = true

        val binding = DataBindingUtil.inflate<FragmentCategoryBinding>(
            inflater,
            R.layout.fragment_category, container, false
        )

        val toolbar = (activity as AppCompatActivity).findViewById<Toolbar>(R.id.toolbar)
        (activity as AppCompatActivity).setSupportActionBar(toolbar)
        (activity as AppCompatActivity).supportActionBar?.hide()
        (activity as AppCompatActivity).findViewById<BottomNavigationView>(R.id.bottomNavigationView).visibility =
            View.GONE

        binding.catToolbar.title = "Productos"
        val category_toolbar = binding.categoryToolbar
        (activity as AppCompatActivity).setSupportActionBar(category_toolbar)
        category_toolbar.setNavigationIcon(R.drawable.ic_arrow_back)
        category_toolbar.setNavigationOnClickListener { activity!!.onBackPressed() }

        binding.lifecycleOwner = this

        categoryModel.productsList.observe(viewLifecycleOwner, Observer {
            println("antes de formar los productos")

            if (it.isNotEmpty() && result) {
                println("entra a formar los productos")

                val adapter = CategoryAdapter(context!!, ArrayList(categoryModel.productsList.value!!))
                binding.foodList.adapter = adapter
                result = false
            }


        })

        categoryModel.getProducts()
        return binding.root
    }
}



