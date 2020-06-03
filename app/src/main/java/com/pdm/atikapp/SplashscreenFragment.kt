package com.pdm.atikapp

import android.animation.ObjectAnimator
import android.animation.PropertyValuesHolder
import android.annotation.SuppressLint
import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import androidx.navigation.NavOptions
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.transition.FragmentTransitionSupport
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_splashscreen.*


/**
 * A simple [Fragment] subclass.
 */
class SplashscreenFragment : Fragment() {

    private val SPLASH_TIME : Long = 4500
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

        (activity as AppCompatActivity).findViewById<BottomNavigationView>(R.id.bottomNavigationView).visibility = View.GONE
        head.startAnimation(ttb)
        sd.startAnimation(pop)
        ss.startAnimation(pap)

        Handler().postDelayed({
           startActivity(Intent(this.context, MainActivity::class.java))
            activity!!.finish()

            findNavController().navigate(R.id.action_splashscreenFragment2_to_login,
                null,
                NavOptions.Builder()
                    .setPopUpTo(R.id.splashscreenFragment2,true).build())
     },SPLASH_TIME)



        return view
    }


}
