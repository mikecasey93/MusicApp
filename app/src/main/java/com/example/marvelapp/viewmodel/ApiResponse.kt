package com.example.marvelapp.viewmodel

sealed class ApiResponse<out T> {
    data class SuccessState<out T>(val data: T): ApiResponse<T>()
    data class ErrorState(val message: String): ApiResponse<Nothing>()
}