package com.pdm.atikapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.pdm.atikapp.databinding.FragmentAdminBinding
import com.pdm.atikapp.databinding.FragmentPrincipalViewBinding
import kotlinx.android.synthetic.main.fragment_admin.*

class AdminFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentAdminBinding>(inflater, R.layout.fragment_admin, container, false)
        val toolbar = (activity as AppCompatActivity).findViewById<Toolbar>(R.id.toolbar)
        (activity as AppCompatActivity).setSupportActionBar(toolbar)
        (activity as AppCompatActivity).supportActionBar?.title = "Administrador"
        (activity as AppCompatActivity).supportActionBar?.setDisplayHomeAsUpEnabled(false)



        binding.productsCard.setOnClickListener {
            it.findNavController().navigate(R.id.action_adminFragment_to_menuFragment)


        }

        binding.ordersCard.setOnClickListener {
            it.findNavController().navigate(R.id.action_adminFragment_to_activeOrdersFragment)
        }

        binding.promotionCard.setOnClickListener {
            it.findNavController().navigate(R.id.action_adminFragment_to_promotionFragment)
        }



        return binding.root
    }

    override fun onResume() {
        super.onResume()
        (activity as AppCompatActivity).findViewById<BottomNavigationView>(R.id.bottomNavigationView).visibility =
            View.VISIBLE
    }

}
