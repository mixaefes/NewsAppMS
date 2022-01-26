package com.example.newsapptask.presentation.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SharedViewModel : ViewModel() {
    val selectedCategory = MutableLiveData<String?>()
    fun selectCategory(category: String?) {
        selectedCategory.value = category
    }
}