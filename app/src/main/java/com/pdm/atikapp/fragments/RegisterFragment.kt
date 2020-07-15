package com.pdm.atikapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.gson.Gson
import com.pdm.atikapp.R
import com.pdm.atikapp.databinding.FragmentLoginBinding
import com.pdm.atikapp.databinding.FragmentRegisterBinding
import com.pdm.atikapp.entity.User
import com.pdm.atikapp.viewModels.UserViewModel

/**
 * A simple [Fragment] subclass.
 */
class RegisterFragment : Fragment() {

    private val UserModel: UserViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        val binding = DataBindingUtil.inflate<FragmentRegisterBinding>(
            inflater,
            R.layout.fragment_register,
            container,
            false
        )
        binding.lifecycleOwner = this

        (activity as AppCompatActivity).findViewById<BottomNavigationView>(R.id.bottomNavigationView).visibility =
            View.GONE

        binding.buttonRegister.setOnClickListener {

            var user = User(
                binding.editName.text.toString(),
                binding.editLastName.text.toString(),
                "dddddx",
                "1",
                binding.editMail.text.toString(),
                binding.editPassword.text.toString()
            )
            println(user)
            UserModel.Registrar(user)

        }

        UserModel.Registrado.observe(viewLifecycleOwner, Observer {

            if (it) {
                println("se va o se queda")
                this.findNavController().navigate(R.id.menu)

            } else {
                Toast.makeText(context!!, "error", Toast.LENGTH_SHORT).show()
            }

        })

        // Inflate the layout for this fragment
        return binding.root
    }

}
