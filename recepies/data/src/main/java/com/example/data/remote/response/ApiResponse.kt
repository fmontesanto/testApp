package com.example.data.remote.response

import com.google.gson.annotations.SerializedName

data class ApiResponse(
    @SerializedName("meals")
    val meals: List<MealResponse>
)