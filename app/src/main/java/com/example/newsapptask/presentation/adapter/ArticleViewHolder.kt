package com.example.newsapptask.presentation.adapter

import androidx.recyclerview.widget.RecyclerView
import com.example.newsapptask.databinding.ArticleItemBinding
import com.example.newsapptask.model.NewsItem

class ArticleViewHolder(private val binding: ArticleItemBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(item: NewsItem) {
        binding.titleTextView.text = item.title
        binding.descriptionTextView.text = item.description
        binding.categoryOfArticleView.text = item.category
    }
}