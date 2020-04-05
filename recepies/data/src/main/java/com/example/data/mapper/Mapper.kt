package com.example.data.mapper

import com.example.data.remote.response.ApiResponse
import com.example.data.remote.response.MealResponse
import com.example.domain.models.MealModel

class Mapper {

    fun mapMeals(apiResponse: ApiResponse): List<MealModel> {
        with(apiResponse) {
            if (meals.isNullOrEmpty()) {
                return emptyList()
            }
            return meals.map { mapMeal(it) }
        }
    }

    private fun mapMeal(mealResponse: MealResponse): MealModel {
        with(mealResponse) {
            return MealModel(
                mealName = mealResponse.strMeal,
                mealCategory = mealResponse.strCategory,
                mealThumbnail = mealResponse.strMealThumb
            )
        }
    }
}