package com.pdm.atikapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_grid_element.*
import java.util.ArrayList

/**
 * A simple [Fragment] subclass.
 */
class PromotionFragment : Fragment() {

    var namePro = arrayListOf<String>(
        "Promotion 1",
        "Promotion 2",
        "Promotion 3"
    )

    var imageArray = arrayOf<Int>(
        R.drawable.circulefour,
        R.drawable.circulefive,
        R.drawable.circulethree
    )

    var description = arrayListOf<String>(
        "Description 1",
         "Description 2",
        "Description3"
  )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view : View = inflater.inflate(R.layout.fragment_promotion, container, false)
        val toolbar = (activity as AppCompatActivity).findViewById<androidx.appcompat.widget.Toolbar>(R.id.toolbar)
        toolbar.title="Promotion"
        (activity as AppCompatActivity).setSupportActionBar(toolbar)
        (activity as AppCompatActivity).supportActionBar?.show()
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back)
        toolbar.setNavigationOnClickListener { activity!!.onBackPressed() }
        (activity as AppCompatActivity).findViewById<BottomNavigationView>(R.id.bottomNavigationView).visibility = View.GONE


        var gv = view.findViewById<GridView>(R.id.ppGrid)
        val adapter= PromotionAdapter(context!!, imageArray, namePro, description)
        gv.adapter = adapter

        gv.numColumns = 1
        gv.horizontalSpacing = 15
        gv.verticalSpacing = 25
        gv.stretchMode = GridView.STRETCH_COLUMN_WIDTH
        return view
    }

}
