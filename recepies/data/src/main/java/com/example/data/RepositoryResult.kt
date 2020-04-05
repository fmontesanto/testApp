package com.example.data

sealed class RepositoryResult<out T : Any> {
    data class Success<out T : Any>(val data: T) : RepositoryResult<T>()
    data class Error(val exception: Exception) : RepositoryResult<Nothing>()
}