package com.example.recepies.ui.home

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.domain.models.MealModel
import com.example.recepies.R
import kotlinx.android.synthetic.main.viewholder_recipe_item.view.*


class MealsAdapter(
    private var meals: List<MealModel>,
    private val context: Context
) : RecyclerView.Adapter<MealsAdapter.MealItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MealItemViewHolder {
        val view: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.viewholder_recipe_item, parent, false)
        return MealItemViewHolder(view)
    }

    override fun getItemCount(): Int = meals.size

    override fun onBindViewHolder(holder: MealItemViewHolder, position: Int) {
        holder.apply {
            with(meals[position]) {
                tvMealName.text = mealName
                tvMealCategory.text = mealCategory
                loadImageIntoView(vMealThumb, mealThumbnail)
            }
        }
    }

    fun updateList(meals: List<MealModel>) {
        this.meals = meals
    }

    private fun loadImageIntoView(imageView: ImageView, imageUrl: String?) {
        Glide
            .with(context)
            .load(imageUrl)
            .fitCenter()
            .into(imageView)
    }

    class MealItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvMealName: TextView = itemView.tvMealName
        val tvMealCategory: TextView = itemView.vMealCategory
        val vMealThumb: ImageView = itemView.vMealThumbnail
    }
}