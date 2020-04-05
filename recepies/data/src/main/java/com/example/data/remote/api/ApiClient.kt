package com.example.data.remote.api

import com.example.data.remote.response.ApiResponse
import retrofit2.Response

interface ApiClient {
    suspend fun searchRecipes(searchText: String): Response<ApiResponse>
}