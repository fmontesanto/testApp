package com.example.usecase.usecases

import com.example.data.Repository
import com.example.data.RepositoryResult
import com.example.domain.models.MealModel
import com.example.usecase.UseCaseResult

class SearchRecipes (private val repository: Repository) {
    suspend operator fun invoke(searchText: String): UseCaseResult<List<MealModel>> {
        return try {
            val searchResponse = repository.searchRecipes(searchText)
            when (searchResponse) {
                is RepositoryResult.Success -> UseCaseResult.Success(searchResponse.data)
                is RepositoryResult.Error -> UseCaseResult.Error(searchResponse.exception)
            }
        } catch (e: Exception) {
            UseCaseResult.Error(e)
        }
    }
}