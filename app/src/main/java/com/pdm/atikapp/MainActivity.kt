package com.pdm.atikapp

import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.channels.ActorScope

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupViews()

     val orientation = resources.getBoolean(R.bool.portrait_only)

        if(orientation){
           this.requestedOrientation.and(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)
        }else{
            this.requestedOrientation.and(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE)
        }
    }

    fun setupViews()
    {
        var navController = findNavController(R.id.fragment)

        bottomNavigationView.setupWithNavController(navController)
    }


}
