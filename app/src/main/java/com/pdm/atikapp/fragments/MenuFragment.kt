package com.pdm.atikapp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridView
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.pdm.atikapp.MenuAdapter
import com.pdm.atikapp.R
import com.pdm.atikapp.databinding.FragmentMenuBinding
import com.pdm.atikapp.viewModels.ProductViewModel

/**
 * A simple [Fragment] subclass.
 */
class MenuFragment : Fragment() {
    private val productModel: ProductViewModel by activityViewModels()

    var nameArray = arrayListOf<String>(
        "Categoria 1",
        "Categoria 2",
        "Categoria 3",
        "Categoria 4",
        "Categoria 5",
        "Categoria 6"
    )

    var imageArray = arrayOf<Int>(
        R.drawable.ic_sweet,
        R.drawable.ic_jar,
        R.drawable.ic_cake,
        R.drawable.ic_cupcake,
        R.drawable.ic_bread,
        R.drawable.ic_glutenfree
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        var result = true

        val binding = DataBindingUtil.inflate<FragmentMenuBinding>(inflater,
            R.layout.fragment_menu, container, false)
        binding.lifecycleOwner = this



//        ProductModel.login(binding.nombre.text.tostrin(),binding.password.text.tostrin())

        productModel.ListaCategorias.observe(viewLifecycleOwner , Observer {
            println("que valor tienen esa cosa:" + it)

            if(it.isNotEmpty() && result){
                println("entra a formar las categorias")
                var id = ArrayList<Int>()
                var images = ArrayList<String>()
                var Categories = ArrayList<String>()
                productModel.ListaCategorias.value!!.forEach { cat->
                    id.add(cat.id)
                    Categories.add(cat.name)
                    images.add(cat.imageUrl)
                    println(cat.products)
                    println(cat.imageUrl)
                    println("estas son las imagenes")
                }

                val view: View = inflater.inflate(R.layout.fragment_menu, container, false)
                val toolbar = (activity as AppCompatActivity).findViewById<androidx.appcompat.widget.Toolbar>(R.id.toolbar)
                toolbar.title = "Menu"
                (activity as AppCompatActivity).setSupportActionBar(toolbar)
                (activity as AppCompatActivity).supportActionBar?.show()
                toolbar.setNavigationIcon(R.drawable.ic_arrow_back)
                toolbar.setNavigationOnClickListener { activity!!.onBackPressed() }
                (activity as AppCompatActivity).findViewById<BottomNavigationView>(R.id.bottomNavigationView).visibility = View.GONE



                val adapter = MenuAdapter(context!!, id, images, Categories)
                binding.mainGrid.adapter = adapter

                binding.mainGrid.numColumns = 2
                binding.mainGrid.horizontalSpacing = 15
                binding.mainGrid.verticalSpacing = 25
                binding.mainGrid.stretchMode = GridView.STRETCH_COLUMN_WIDTH
                result = false
            }



        })

        productModel.getCategorias()





        return binding.root
    }

}
