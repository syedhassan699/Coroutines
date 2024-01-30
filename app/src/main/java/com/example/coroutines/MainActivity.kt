package com.example.coroutines

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.coroutines.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding
    private var counter = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        binding= ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


        binding.btnCount.setOnClickListener {
            binding.countView.text = counter++.toString()
        }

        binding.btnDownload.setOnClickListener {
        CoroutineScope(Dispatchers.IO).launch {
            for (i in 1..1000000){
                Log.i("TAG","Downloading $i in ${Thread.currentThread().name}}")
            }
        }
        }
    }


}