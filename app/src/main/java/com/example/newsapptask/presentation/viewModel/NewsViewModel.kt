package com.example.newsapptask.presentation.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsapptask.data.NewsApiService
import com.example.newsapptask.model.NewsList
import kotlinx.coroutines.launch

class NewsViewModel() : ViewModel() {
    private val _items = MutableLiveData<NewsList>()
    val items: LiveData<NewsList> get() = _items

    /*    init {
            viewModelScope.launch {
                _items.value = NewsApiService.getNewsService()
            }
        }*/
    fun getData(category: String) {
        viewModelScope.launch {
            _items.value = NewsApiService.getNewsService(category)
        }
    }
}