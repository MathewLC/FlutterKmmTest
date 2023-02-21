package com.example.flutterkmmtest1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.flutterkmmtest1.databinding.ActivityMainBinding
import com.example.flutterkmmtest1.viewModel.MainActivityViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val myViewModel by viewModel<MainActivityViewModel>()
    private lateinit var mainBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)
        listenToPizzas()
    }

    private fun listenToPizzas() {
        myViewModel.pizzaList.observe(this) { pizzaList ->
            mainBinding.text1.text =
                pizzaList.joinToString(separator = "\n") { it.name }
        }
    }
}