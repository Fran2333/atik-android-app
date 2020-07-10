package com.pdm.atikapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.View.inflate
import android.view.ViewGroup
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.databinding.DataBindingUtil.inflate
import androidx.lifecycle.ViewModelProviders
import com.pdm.atikapp.databinding.FragmentActiveOrdersBinding.inflate
import com.pdm.atikapp.databinding.FragmentLoginBinding.inflate
import com.pdm.atikapp.databinding.FragmentRegisterBinding.inflate
import com.pdm.atikapp.overview.OverViewModelLocation


/**
 * A simple [Fragment] subclass.
 */
class LocationsFragment : Fragment() {
    var titleArray = arrayListOf<String>(
        "Ubicacion 1",
        "Ubicacion 2"
    )

    var descArray = arrayListOf<String>(
        "Descripcion 1",
        "Descripcion 2"
    )

   // var imageArray = arrayOf<Int>(
      //  R.drawable.ic_signs,
      //  R.drawable.ic_signs
    //)

    private val viewModel : OverViewModelLocation by lazy {
        ViewModelProviders.of(this).get(OverViewModelLocation::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_locations, container, false)
        //val binding = LocationsFragment.inflate(inflater)



        val toolbar = (activity as AppCompatActivity).findViewById<androidx.appcompat.widget.Toolbar>(R.id.toolbar)
        toolbar.title = "Ubicaciones"
        (activity as AppCompatActivity).setSupportActionBar(toolbar)
        (activity as AppCompatActivity).supportActionBar?.show()
        (activity as AppCompatActivity).supportActionBar?.setDisplayHomeAsUpEnabled(false)

        var lv = view.findViewById<ListView>(R.id.locations_list)

        val adapter = LocationAdapter(context!!, titleArray, descArray)//, imageArray)
        lv.adapter = adapter



        return view
    }

}
