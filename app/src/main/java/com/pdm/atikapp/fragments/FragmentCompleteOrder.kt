package com.pdm.atikapp.fragments

import android.app.DatePickerDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.pdm.atikapp.R
import kotlinx.android.synthetic.main.fragment_complete_order.*
import java.util.*

/**
 * A simple [Fragment] subclass.
 */
class FragmentCompleteOrder : Fragment() {



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val toolbar = (activity as AppCompatActivity).findViewById<androidx.appcompat.widget.Toolbar>(
            R.id.toolbar
        )
        toolbar.title = "Completa tu orden"
        (activity as AppCompatActivity).setSupportActionBar(toolbar)
        (activity as AppCompatActivity).supportActionBar?.show()
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back)
        toolbar.setNavigationOnClickListener { activity!!.onBackPressed() }

        // Inflate the layout for this fragment
        val view:View = inflater.inflate(R.layout.fragment_complete_order, container, false)
        val btnDay = view.findViewById<Button>(R.id.btn_day)


        btnDay.setOnClickListener {
            DatePicker()

        }

        return view;
    }

  private fun DatePicker(){

    val now = Calendar.getInstance()

    val year = now.get(Calendar.YEAR)
    val month = now.get(Calendar.MONTH)
    val day = now.get(Calendar.DAY_OF_MONTH)
    val datePicker = DatePickerDialog(context!!, DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->
        btn_day.text="Fecha: " + dayOfMonth + " / " + (month +1)+ " / " + year
    },day,month,year)

    datePicker.show()
}
}
