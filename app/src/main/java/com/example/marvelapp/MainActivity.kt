package com.example.marvelapp

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.marvelapp.viewmodel.MusicViewModel
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.marvelapp.model.ResultModel
import com.sample.myapplication.R
import com.sample.myapplication.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity: AppCompatActivity() {

//    private val viewModel: MusicViewModel by viewModels()
    private val viewModel: MusicViewModel by viewModels()

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.fetchMusicData()

        viewModel.musicLiveData.observe(this) {
            binding.rvMusic.apply{
                layoutManager = LinearLayoutManager(context)
                adapter = MusicAdapter(it)
            }
        }
    }
}