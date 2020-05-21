package com.pdm.atikapp

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.LinearLayout.*
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

/**
 * A simple [Fragment] subclass.
 */
class PromotionFragment : Fragment() {
    private val recyclerView: RecyclerView? = view?.findViewById(R.id.recycler)
    @SuppressLint("WrongConstant")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_promotion, container, false)

        recyclerView?.layoutManager =LinearLayoutManager(this.context, LinearLayout.VERTICAL, false)

        val albums = ArrayList<Album>()

        albums.add(Album("Promotion 1", "adsag", R.drawable.icon))
        albums.add(Album("Promotion 2", "ddsgsg", R.drawable.icontwo))
        albums.add(Album("Promotion 3", "ddsgadsdasg", R.drawable.iconthree))

        val adapter = AdapterAlbum(albums)


        recyclerView!!.adapter =adapter
    }



}
