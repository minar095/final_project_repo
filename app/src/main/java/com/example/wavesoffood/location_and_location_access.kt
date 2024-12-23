package com.example.wavesoffood

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.wavesoffood.databinding.ActivityLocationAndLocationAccessBinding

class LocationAndLocationAccessActivity : AppCompatActivity() {
    private val binding :ActivityLocationAndLocationAccessBinding by lazy {
        ActivityLocationAndLocationAccessBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
      val locationList:Array<String>=arrayOf("Pahartali","Santihat","Noapara","Karnafully Bridge","Power Station Near Cuet","GEC","Bodderhat","Muradpur","Raster Matha","Lalkhan Bazar","Khulsi")
        val adapter=ArrayAdapter(this,android.R.layout.simple_list_item_1,locationList)

       val autoCompleteTextView : AutoCompleteTextView= binding.
        autoCompleteTextView.setAdapter(adapter)

    }
}