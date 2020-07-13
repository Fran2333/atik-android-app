package com.pdm.atikapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.View.inflate
import android.view.ViewGroup
import android.widget.GridView
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer


import com.pdm.atikapp.R
import com.pdm.atikapp.adapters.LocationAdapter
import com.pdm.atikapp.databinding.FragmentLocationsBinding
import com.pdm.atikapp.viewModels.locationsViewModel


/**
 * A simple [Fragment] subclass.
 */
class LocationsFragment : Fragment() {

    private val LocationModel: locationsViewModel by activityViewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        var result: Boolean = true

        val binding = DataBindingUtil.inflate<FragmentLocationsBinding>(
            inflater, R.layout.fragment_locations, container, false
        )
        binding.lifecycleOwner = this

        println("antes del viewmodel")
        LocationModel.listLocations.observe(viewLifecycleOwner, Observer {
            println("entre al viewmodel")

            if (it.isNotEmpty() && result) {
                println("entre a formar ubicaciones")


                val toolbar =
                    (activity as AppCompatActivity).findViewById<androidx.appcompat.widget.Toolbar>(
                        R.id.toolbar
                    )
                toolbar.title = "Ubicaciones"
                (activity as AppCompatActivity).setSupportActionBar(toolbar)
                (activity as AppCompatActivity).supportActionBar?.show()
                (activity as AppCompatActivity).supportActionBar?.setDisplayHomeAsUpEnabled(false)

                val adapter =
                    LocationAdapter(context!!, ArrayList(LocationModel.listLocations.value!!))
                binding.locationGrid.adapter = adapter

                binding.locationGrid.numColumns = 1
                binding.locationGrid.horizontalSpacing = 15
                binding.locationGrid.verticalSpacing = 25
                binding.locationGrid.stretchMode = GridView.STRETCH_COLUMN_WIDTH
                result = false
            }
        })
        LocationModel.getLocations()


        return binding.root
    }

}
