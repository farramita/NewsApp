package com.example.mynewsapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.mynewsapp.R
import com.example.mynewsapp.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    lateinit var binding:ActivityMainBinding
    private val viewModel : MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        val mainAdapter = MainAdapter()
        binding.recyclerView.adapter = mainAdapter

        viewModel.articles.observe(this) {
            mainAdapter.submitList(it)
        }

        setContentView(binding.root)

    }

}