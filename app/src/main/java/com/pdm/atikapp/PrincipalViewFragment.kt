package com.pdm.atikapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.pdm.atikapp.databinding.FragmentPrincipalViewBinding

/**
 * A simple [Fragment] subclass.
 */
class PrincipalViewFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var binding = DataBindingUtil.inflate<FragmentPrincipalViewBinding>(inflater, R.layout.fragment_principal_view,
            container, false
        )

        val toolbar = (activity as AppCompatActivity).findViewById<Toolbar>(R.id.toolbar)
        (activity as AppCompatActivity).setSupportActionBar(toolbar)
        (activity as AppCompatActivity).supportActionBar?.hide()

        binding.textView2.setOnClickListener {
            it.findNavController().navigate(R.id.action_principalViewFragment_to_menuFragment)
        }


        binding.textView3.setOnClickListener{
            it.findNavController().navigate(R.id.action_principalViewFragment_to_promotionFragment2)
        }

        binding.textView4.setOnClickListener {
            it.findNavController().navigate(R.id.action_principalViewFragment_to_personalizeOrder2)
        }

        return binding.root
    }

    override fun onResume() {
        super.onResume()
        (activity as AppCompatActivity).findViewById<BottomNavigationView>(R.id.bottomNavigationView).visibility = View.VISIBLE
    }

}
