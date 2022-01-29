package com.example.newsapptask.data

import com.example.newsapptask.R
import com.example.newsapptask.model.Category

object CategoriesSource {
    fun loadCategories():List<Category>{
        return listOf(
            Category(R.drawable.category_general,R.string.category_general),
            Category(R.drawable.category_business,R.string.category_business),
            Category(R.drawable.category_health,R.string.category_health),
            Category(R.drawable.category_science,R.string.category_science),
            Category(R.drawable.category_sport,R.string.category_sports),
            Category(R.drawable.category_entertainment,R.string.category_entertainment),
            Category(R.drawable.category_technology,R.string.category_technology),
            Category(R.drawable.category_favorites,R.string.category_favorites)
        )
    }
}