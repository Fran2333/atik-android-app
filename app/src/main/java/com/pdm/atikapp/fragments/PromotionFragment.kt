package com.pdm.atikapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridView
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.pdm.atikapp.R
import com.pdm.atikapp.adapters.PromotionAdapter
import com.pdm.atikapp.databinding.FragmentPromotionBinding
import com.pdm.atikapp.viewModels.PromotionsViewModel
import kotlinx.android.synthetic.main.activity_grid_element.*

/**
 * A simple [Fragment] subclass.
 */
class PromotionFragment : Fragment() {


    private val promotionModel: PromotionsViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        super.onCreateView(inflater, container, savedInstanceState)
        var result: Boolean = true

        val binding = DataBindingUtil.inflate<FragmentPromotionBinding>(
            inflater, R.layout.fragment_promotion, container, false
        )

        binding.lifecycleOwner = this

        println("antes del viewmodel de promociones")
        promotionModel.listPromotions.observe(viewLifecycleOwner, Observer {
            println("entre al viewmodel de promociones")

            if (it.isNotEmpty() && result) {
                println("entre a tomar las promociones")


                val toolbar =
                    (activity as AppCompatActivity).findViewById<androidx.appcompat.widget.Toolbar>(
                        R.id.toolbar
                    )
                toolbar.title = "Promociones"
                (activity as AppCompatActivity).setSupportActionBar(toolbar)
                (activity as AppCompatActivity).supportActionBar?.show()
                toolbar.setNavigationIcon(R.drawable.ic_arrow_back)
                toolbar.setNavigationOnClickListener { activity!!.onBackPressed() }
                (activity as AppCompatActivity).findViewById<BottomNavigationView>(R.id.bottomNavigationView).visibility =
                    View.GONE


                val adapter =
                    PromotionAdapter(context!!, ArrayList(promotionModel.listPromotions.value!!))
                binding.ppGrid.adapter = adapter

                binding.ppGrid.numColumns = 1
                binding.ppGrid.horizontalSpacing = 15
                binding.ppGrid.verticalSpacing = 25
                binding.ppGrid.stretchMode = GridView.STRETCH_COLUMN_WIDTH
                result = false

            }
        })

        promotionModel.getPromotions()

        return binding.root
    }

}
