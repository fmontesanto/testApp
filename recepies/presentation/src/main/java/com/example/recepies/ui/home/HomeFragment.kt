package com.example.recepies.ui.home

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.domain.models.MealModel
import com.example.recepies.BaseFragment
import com.example.recepies.R
import kotlinx.android.synthetic.main.fragment_home.*
import org.koin.android.scope.currentScope
import org.koin.core.parameter.parametersOf

class HomeFragment : BaseFragment(), HomeView {

    private lateinit var mealsAdapter: MealsAdapter
    private val presenter: HomePresenter by currentScope.inject { parametersOf(this) }

    override fun getLayoutResourceId(): Int = R.layout.fragment_home

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.onInit()
    }

    override fun setUpLayout(meals: List<MealModel>) {
        setUpMealsList(meals)
        setUpListeners()
    }

    override fun updateMeals(meals: List<MealModel>) {
        mealsAdapter.updateList(meals)
    }

    private fun setUpMealsList(meals: List<MealModel>) {
        mealsAdapter = MealsAdapter(meals, requireContext())
        rvRecipesList.apply {
            adapter = mealsAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }
    }

    private fun setUpListeners() {
        vRecipeEditText.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(text: Editable?) {
                if (!text.isNullOrEmpty() && text.length > 3) {
                    presenter.onEditTextChange(text.toString())
                }
            }

            override fun beforeTextChanged(
                s: CharSequence?,
                start: Int,
                count: Int,
                after: Int
            ) {}

            override fun onTextChanged(text: CharSequence?, start: Int, before: Int, count: Int) {

            }
        })
    }

    override fun toggleProgress(toggle: Boolean) {
        (activity as HomeActivity).toggleProgress(toggle)
    }

    override fun displayMessage(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_LONG).show()
    }
}