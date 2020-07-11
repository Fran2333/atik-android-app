package com.pdm.atikapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.pdm.atikapp.R
import com.pdm.atikapp.databinding.FragmentPrincipalViewBinding

class PrincipalViewFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentPrincipalViewBinding>(inflater,
            R.layout.fragment_principal_view, container, false)
        val toolbar = (activity as AppCompatActivity).findViewById<Toolbar>(R.id.toolbar)
        (activity as AppCompatActivity).setSupportActionBar(toolbar)
        (activity as AppCompatActivity).supportActionBar?.title = "Atik"
        (activity as AppCompatActivity).supportActionBar?.setDisplayHomeAsUpEnabled(false)



        binding.menuCard.setOnClickListener {
            it.findNavController().navigate(R.id.action_principalViewFragment_to_menuFragment)


        }

        binding.specialCard.setOnClickListener {
            it.findNavController().navigate(R.id.action_principalViewFragment_to_specialOrdersFragment)
        }

        binding.promotionCard.setOnClickListener {
            it.findNavController().navigate(R.id.action_principalViewFragment_to_promotionFragment)
        }




        return binding.root
    }

    override fun onResume() {
        super.onResume()
        (activity as AppCompatActivity).findViewById<BottomNavigationView>(R.id.bottomNavigationView).visibility =
            View.VISIBLE
    }

}
