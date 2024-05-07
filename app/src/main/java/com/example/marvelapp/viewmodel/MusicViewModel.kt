package com.example.marvelapp.viewmodel

import android.annotation.SuppressLint
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.marvelapp.model.ResultModel
import com.example.marvelapp.repository.MusicRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MusicViewModel @Inject constructor(private val musicRepository: MusicRepository) : ViewModel(){

    val musicLiveData = MutableLiveData<List<ResultModel>>()
    val errorLiveData = MutableLiveData<String>()

    init {
        musicLiveData.observeForever { results ->
            Log.d("MusicViewModel", "MusicLiveData value: $results")
        }
    }

    @SuppressLint("SuspiciousIndentation")
    fun fetchMusicData() {
        viewModelScope.launch (Dispatchers.IO) {
            val response = musicRepository.getMusic()

            if(response.isSuccessful && response.body() != null) {
                val results = response.body()?.results ?: emptyList()
                musicLiveData.postValue(results.filterNotNull())
            }
            else {
                errorLiveData.postValue(response.errorBody().toString())
                Log.i("Data_Music", response.errorBody().toString())
            }
        }
    }
}