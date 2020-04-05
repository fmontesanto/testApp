package com.example.data

import com.example.data.mapper.Mapper
import com.example.data.remote.api.ApiClient
import com.example.domain.models.MealModel

class Repository(private val api: ApiClient, private val mapper: Mapper) : RepositoryInterface {

    override suspend fun searchRecipes(search: String): RepositoryResult<List<MealModel>> {
        val response = (api.searchRecipes(search))
        if (response.isSuccessful) {
            response.body()?.let {
                val mealsList = mapper.mapMeals(it)
                return RepositoryResult.Success(mealsList)
            }
        }
        return RepositoryResult.Error(
            java.lang.Exception(" ${response.code()} ${response.message()}")
        )
    }
}