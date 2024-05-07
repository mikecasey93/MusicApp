package com.example.marvelapp.repository

import com.example.marvelapp.network.MusicApiService
import javax.inject.Inject

class MusicRepository @Inject constructor(private val service: MusicApiService){
    suspend fun getMusic () = service.getMusic()
}