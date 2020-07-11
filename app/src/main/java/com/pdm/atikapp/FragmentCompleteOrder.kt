package com.pdm.atikapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import android.widget.RadioGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment


/**
 * A simple [Fragment] subclass.
 */
class FragmentCompleteOrder : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val toolbar =
            (activity as AppCompatActivity).findViewById<Toolbar>(R.id.toolbar)
        toolbar.title = "Completa tu orden"
        (activity as AppCompatActivity).setSupportActionBar(toolbar)
        (activity as AppCompatActivity).supportActionBar?.show()
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back)
        toolbar.setNavigationOnClickListener { activity!!.onBackPressed() }

        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_complete_order, container, false)
        val spinner = view?.findViewById<Spinner>(R.id.spinner2);
        val location = arrayOf("--Elegir--","Santa Tecla", "San Salvador")
        val btnRadio2 = view.findViewById<RadioButton>(R.id.btnCollect);

        spinner?.adapter = ArrayAdapter(context!!, R.layout.support_simple_spinner_dropdown_item, location) as SpinnerAdapter
        spinner.isEnabled = false;
        spinner.prompt = "--Elegir--'"

        spinner?.onItemSelectedListener = object : AdapterView.OnItemClickListener,
            AdapterView.OnItemSelectedListener {

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
               if(position!=0){
                   val description: String = location.get(position)

               }


            }

            override fun onItemClick(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                TODO("Not yet implemented")
            }
        }

        val rb = view.findViewById(R.id.opcionesSer) as RadioGroup


        rb.setOnCheckedChangeListener(RadioGroup.OnCheckedChangeListener { group, checkedId ->
            // This will get the radiobutton that has changed in its check state
            val checkedRadioButton =
                group.findViewById<View>(checkedId) as RadioButton
            // This puts the value (true/false) into the variable
            val isChecked = checkedRadioButton.isChecked
            // If the radiobutton that has changed in check state is now checked...
            if (isChecked) {
                // Changes the spinner's state to true by selection btnRadio2
                spinner.isEnabled = checkedRadioButton == btnRadio2
            }
        })




        return view;
    }

}
