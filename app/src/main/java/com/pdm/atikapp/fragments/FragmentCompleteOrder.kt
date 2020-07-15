package com.pdm.atikapp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import android.widget.*
import android.widget.RadioGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import com.pdm.atikapp.R
import com.pdm.atikapp.databinding.FragmentCompleteOrderBinding
import com.pdm.atikapp.entity.Locations
import com.pdm.atikapp.viewModels.LocationsViewModel
import com.pdm.atikapp.viewModels.ProductViewModel
import okio.`-DeprecatedUtf8`.size
import java.nio.file.Files.size


/**
 * A simple [Fragment] subclass.
 */
class FragmentCompleteOrder : Fragment() {
    private val locationModel: LocationsViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        var result = true

        //binding
        val binding = DataBindingUtil.inflate<FragmentCompleteOrderBinding>(
            inflater,
            R.layout.fragment_complete_order, container, false
        )
        binding.lifecycleOwner = this

        println("antes del viewmodel spinner")
        locationModel.listLocations.observe(viewLifecycleOwner, Observer {
            println("entre al viewmodel spinner")

            if (it.isNotEmpty() && result) {
                println("entre a formar ubicaciones")

                var ubicacions = ArrayList<String>()
                var name = ArrayList<String>()

                locationModel.listLocations.value!!.forEach { lo ->

                    ubicacions.add(lo.address)
                    name.add(lo.name)
                    println("aca agrego las ubicaciones")
                }

                //toolbar
                val toolbar =
                    (activity as AppCompatActivity).findViewById<Toolbar>(R.id.toolbar)
                toolbar.title = "Completa tu orden"
                (activity as AppCompatActivity).setSupportActionBar(toolbar)
                (activity as AppCompatActivity).supportActionBar?.show()
                toolbar.setNavigationIcon(R.drawable.ic_arrow_back)
                toolbar.setNavigationOnClickListener { activity!!.onBackPressed() }

                // Inflate the layout for this fragment
                val view: View =
                    inflater.inflate(R.layout.fragment_complete_order, container, false)
                val spinner = binding.spinner2
                val btnRadio2 = binding.btnCollect

                spinner?.adapter = ArrayAdapter(
                    context!!,
                    R.layout.support_simple_spinner_dropdown_item,
                    ubicacions
                ) as SpinnerAdapter
                spinner?.isEnabled = false;



                spinner?.onItemSelectedListener = object : AdapterView.OnItemClickListener,
                    AdapterView.OnItemSelectedListener {
                    override fun onItemClick(
                        parent: AdapterView<*>?,
                        view: View?,
                        position: Int,
                        id: Long
                    ) {
                        TODO("Not yet implemented")
                    }

                    override fun onNothingSelected(parent: AdapterView<*>?) {
                        TODO("Not yet implemented")
                        println("erreur")
                    }

                    override fun onItemSelected(
                        parent: AdapterView<*>?,
                        view: View?,
                        position: Int,
                        id: Long
                    ) {
                        val type = parent?.getItemAtPosition(position).toString()
                        if (position != 0) {
                            val description: String = name[position]

                        }
                    }

                }

                val rb = binding.opcionesSer


                rb.setOnCheckedChangeListener(RadioGroup.OnCheckedChangeListener { group, checkedId ->
                    // This will get the radiobutton that has changed in its check state
                    val checkedRadioButton =
                        binding.root.findViewById<View>(checkedId) as RadioButton
                    // This puts the value (true/false) into the variable
                    val isChecked = checkedRadioButton.isChecked
                    // If the radiobutton that has changed in check state is now checked...
                    if (isChecked) {
                        // Changes the spinner's state to true by selection btnRadio2
                        spinner?.isEnabled = checkedRadioButton == btnRadio2
                    }
                })
            }
        })

        locationModel.getLocations()







        return binding.root
    }

}
