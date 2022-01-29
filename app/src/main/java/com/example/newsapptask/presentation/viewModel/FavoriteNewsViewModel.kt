package com.example.newsapptask.presentation.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.newsapptask.model.FavoriteNews
import com.example.newsapptask.model.NewsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.launch

@HiltViewModel
class FavoriteNewsViewModel @Inject constructor(
    private val repository: NewsRepository
) : ViewModel() {
    val allFavoriteNewsList: LiveData<List<FavoriteNews>> = repository.allFavoriteNews
    fun deleteFavoriteNews(favoriteNews: FavoriteNews) = viewModelScope.launch {
        repository.deleteNews(favoriteNews)
    }

    fun insertFavoriteNews(favoriteNews: FavoriteNews) = viewModelScope.launch {
        repository.insertNews(favoriteNews)
    }
}


