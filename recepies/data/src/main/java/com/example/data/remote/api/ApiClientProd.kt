package com.example.data.remote.api

import com.example.data.remote.response.ApiResponse
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.http.Query

class ApiClientProd(private val retrofit: Retrofit) : ApiClient {

    override suspend fun searchRecipes(searchText: String): Response<ApiResponse> {
        return retrofit
            .create(TheMealDbService::class.java)
            .searchMeals(searchText)
    }

    companion object {
        const val KEY_SEARCH = "s"
        const val BASE_URL = "https://www.themealdb.com/api/json/v1/1/"
    }
}

interface TheMealDbService {
    @GET("search.php?")
    suspend fun searchMeals(
        @Query(ApiClientProd.KEY_SEARCH) searchText: String
    ): Response<ApiResponse>

}