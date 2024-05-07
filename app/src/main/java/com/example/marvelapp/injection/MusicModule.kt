package com.example.marvelapp.injection

import com.example.marvelapp.network.MusicApiService
import com.example.marvelapp.repository.MusicRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

@Module
@InstallIn(SingletonComponent::class)
class MusicModule {

    @Singleton
    @Provides
    fun provideApiServiceObject(): MusicApiService =
        Retrofit.Builder()
            .baseUrl("https://itunes.apple.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(MusicApiService::class.java)

    @Singleton
    @Provides
    fun provideMusicRepo(): MusicRepository =
        MusicRepository(provideApiServiceObject())

}