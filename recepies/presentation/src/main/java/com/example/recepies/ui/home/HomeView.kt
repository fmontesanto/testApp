package com.example.recepies.ui.home

import com.example.domain.models.MealModel

interface HomeView {

    fun setUpLayout(meals: List<MealModel>)

    fun updateMeals(meals: List<MealModel>)

    fun toggleProgress(toggle: Boolean)

    fun displayMessage (message : String)
}