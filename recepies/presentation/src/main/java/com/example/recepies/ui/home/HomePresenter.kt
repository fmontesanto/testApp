package com.example.recepies.ui.home

import com.example.domain.models.MealModel

class HomePresenter(private val view: HomeView) {
    private val meals = ArrayList<MealModel>()

    fun onInit() {
        view.setUpLayout(meals)
    }

}