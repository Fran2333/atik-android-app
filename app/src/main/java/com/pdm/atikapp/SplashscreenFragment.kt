package com.pdm.atikapp

import android.animation.ObjectAnimator
import android.animation.PropertyValuesHolder
import android.annotation.SuppressLint
import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.ImageView
import androidx.fragment.app.FragmentManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_splashscreen.*


/**
 * A simple [Fragment] subclass.
 */
class SplashscreenFragment : Fragment() {

    private val SPLASH_TIME : Long = 5000
    @SuppressLint("ResourceType")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view : View =  inflater.inflate(R.layout.fragment_splashscreen, container, false)

        val ttb = AnimationUtils.loadAnimation(this.context, R.anim.zickt)
        val pop = AnimationUtils.loadAnimation(this.context, R.anim.zict);
        val pap = AnimationUtils.loadAnimation(this.context, R.anim.ziit);

        val head = view.findViewById(R.id.cake_image) as ImageView
        val sd = view.findViewById(R.id.chef_image) as ImageView
        val ss = view.findViewById(R.id.ingredients_image) as ImageView

        head.startAnimation(ttb)
        sd.startAnimation(pop)
        ss.startAnimation(pap)




        return view
    }


}
