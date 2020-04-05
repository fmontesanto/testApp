package com.example.domain.models

import java.io.Serializable

data class MealModel(
    val mealName: String,
    val mealCategory: String,
    val mealThumbnail: String
) : Serializable {
}