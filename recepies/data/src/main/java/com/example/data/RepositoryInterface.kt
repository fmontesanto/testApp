package com.example.data

import com.example.domain.models.MealModel

interface RepositoryInterface {
    suspend fun searchRecipes(search: String): RepositoryResult<List<MealModel>>
}