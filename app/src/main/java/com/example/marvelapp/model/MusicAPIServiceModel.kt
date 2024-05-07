package com.example.marvelapp.model


import com.google.gson.annotations.SerializedName

data class MusicAPIServiceModel(
    @SerializedName("resultCount")
    val resultCount: Int? = 0,
    @SerializedName("results")
    val results: List<ResultModel?>? = listOf()
)