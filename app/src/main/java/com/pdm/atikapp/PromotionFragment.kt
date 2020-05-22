package com.pdm.atikapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridView
import java.util.ArrayList

/**
 * A simple [Fragment] subclass.
 */
class PromotionFragment : Fragment() {

    var namePro = arrayListOf<String>(
        "Promotion 1",
        "Promotion 2",
        "Promotion 3",
        "Promotion 4",
        "Promotion 5",
        "Promotion 6"
    )

    var imageArray = arrayOf<Int>(
        R.drawable.icon,
        R.drawable.icontwo,
        R.drawable.iconthree,
        R.drawable.iconf,
        R.drawable.iconff,
        R.drawable.iconst
    )
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view : View = inflater.inflate(R.layout.fragment_promotion, container, false)

        var gv = view.findViewById<GridView>(R.id.ppGrid)
        val adapter= PromotionAdapter(context!!, this.imageArray, this.namePro)
        gv.adapter = adapter

        gv.numColumns = 2
        gv.horizontalSpacing = 15
        gv.verticalSpacing = 25
        gv.stretchMode = GridView.STRETCH_COLUMN_WIDTH
        return view
    }

}
