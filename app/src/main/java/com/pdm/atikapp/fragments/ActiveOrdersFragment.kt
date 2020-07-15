package com.pdm.atikapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import com.pdm.atikapp.R
import com.pdm.atikapp.adapters.ActiveOrderAdapter
import com.pdm.atikapp.databinding.FragmentActiveOrdersBinding
import com.pdm.atikapp.viewModels.ActiveOrderViewModel
import kotlinx.android.synthetic.main.activity_grid_element.*

/**
 * A simple [Fragment] subclass.
 */
class ActiveOrdersFragment : Fragment() {

    private val activeModel: ActiveOrderViewModel by activityViewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //binding this view
        super.onCreateView(inflater, container, savedInstanceState)
        var result: Boolean = true

        val binding = DataBindingUtil.inflate<FragmentActiveOrdersBinding>(
            inflater,
            R.layout.fragment_active_orders,
            container,
            false
        )
        binding.lifecycleOwner = this

        println("antes del view model")
        activeModel.activeList.observe(viewLifecycleOwner, Observer {
            println("entre al viewmodel")

            if (it.isNotEmpty() && result) {
                val toolbar =
                    (activity as AppCompatActivity).findViewById<androidx.appcompat.widget.Toolbar>(
                        R.id.toolbar
                    )
                toolbar.title = "Ordenes Activas"
                (activity as AppCompatActivity).setSupportActionBar(toolbar)
                (activity as AppCompatActivity).supportActionBar?.show()
                (activity as AppCompatActivity).supportActionBar?.setDisplayHomeAsUpEnabled(false)

                val adapter =
                    ActiveOrderAdapter(context!!, ArrayList(activeModel.activeList.value!!))
                binding.activeOrdersList.adapter = adapter

            }
        })
        activeModel.getOrders()



        return binding.root
    }

}
