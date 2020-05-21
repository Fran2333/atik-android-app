package com.pdm.atikapp

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.checkSelfPermission
import  kotlinx.android.synthetic.main.fragment_special_orders.*


class SpecialOrdersFragment : Fragment() {

      val REQUEST_GALLERY = 1001


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {


        this.activity?.setTitle(R.string.view_special_orders_name)
        // Inflate the layout for this fragment
         return inflater.inflate(R.layout.fragment_special_orders, container, false)
        open()

    }

    fun open(){
        buttonImagen.setOnClickListener() {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                if (checkSelfPermission(context!!,Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED) {
                    val permissionRecords = arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE)
                    requestPermissions(permissionRecords, REQUEST_GALLERY)
                } else {
                    showGallery()
                }
            } else {
                showGallery()
            }
        }


    }


   fun showGallery(){

      Toast.makeText(context,"ok",Toast.LENGTH_SHORT).show()
  }
}






