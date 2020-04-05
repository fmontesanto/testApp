package com.example.domain.models

import java.io.Serializable

data class MealModel(
    private val mealName: String,
    private val mealCategory: String,
    private val mealThumbnail: String
) : Serializable {
}