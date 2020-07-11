package com.pdm.atikapp

import android.content.Context
import android.content.pm.ActivityInfo
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.pdm.atikapp.network.AtikAppService2
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        AtikAppService2.init()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        var navController = findNavController(R.id.fragment)

        bottomNavigationView.setupWithNavController(navController)

        val orientation = resources.configuration.orientation

        fun isLargeScreen(context: Context): Boolean {
            return ((context.getResources().getConfiguration().screenLayout
                    and Configuration.SCREENLAYOUT_SIZE_MASK)
                    >= Configuration.SCREENLAYOUT_SIZE_LARGE)
        }

        if (orientation != Configuration.ORIENTATION_PORTRAIT) {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)
        } else if (isLargeScreen(getApplicationContext())) {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_SENSOR)
        }
    }
}
