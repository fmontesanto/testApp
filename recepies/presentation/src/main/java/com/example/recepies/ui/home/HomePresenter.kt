package com.example.recepies.ui.home

import com.example.domain.models.MealModel
import com.example.usecase.UseCaseResult
import com.example.usecase.usecases.SearchRecipes
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class HomePresenter(
    private val view: HomeView,
    private val searchRecipes: SearchRecipes
) {

    fun onInit() {
        view.setUpLayout(emptyList())
    }

    fun onEditTextChange(searchText: String) {
        view.toggleProgress(true)
        CoroutineScope(Dispatchers.IO).launch {
            val searchResult = searchRecipes(searchText)
            withContext(Dispatchers.Main) {
                handleUseCaseResult(searchResult)
            }
        }
    }

    private fun handleUseCaseResult(result: UseCaseResult<List<MealModel>>) {
        view.toggleProgress(false)
        when (result) {
            is UseCaseResult.Success -> { view.updateMeals(result.data) }
            is UseCaseResult.Error -> view.displayMessage(ERROR_MESSAGE)
        }
    }

    companion object {
        const val ERROR_MESSAGE = "Error retrieving information"
    }

}