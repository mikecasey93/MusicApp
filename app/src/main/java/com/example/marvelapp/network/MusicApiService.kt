package com.example.marvelapp.network

import com.example.marvelapp.model.MusicAPIServiceModel
import com.example.marvelapp.model.ResultModel
import retrofit2.Response
import retrofit2.http.GET

interface MusicApiService {
    @GET("search?term=classick&amp;media=music&amp;entity=song&amp;limit=50")
    suspend fun getMusic(): Response<MusicAPIServiceModel>
}