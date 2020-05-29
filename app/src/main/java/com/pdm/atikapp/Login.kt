package com.pdm.atikapp

import android.content.pm.ActivityInfo
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.pdm.atikapp.databinding.FragmentLoginBinding

/**
 * A simple [Fragment] subclass.
 */
class Login : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //val view: View = inflater.inflate(R.layout.fragment_locations, container, false)
        val binding = DataBindingUtil.inflate<FragmentLoginBinding>(
            inflater,
            R.layout.fragment_login,
            container,
            false
        )

        binding.button.setOnClickListener { view: View ->
            view.findNavController().navigate(R.id.action_login_to_principalViewFragment)

        }

        binding.textView3.setOnClickListener {
            it.findNavController().navigate(R.id.action_login_to_registerFragment)
        }

        (activity as AppCompatActivity).findViewById<BottomNavigationView>(R.id.bottomNavigationView).visibility =
            View.GONE


        // Inflate the layout for this fragment
        return binding.root
    }

}
