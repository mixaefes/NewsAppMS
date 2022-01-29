package com.example.newsapptask.presentation.adapter

import androidx.recyclerview.widget.RecyclerView
import com.example.newsapptask.databinding.ArticleItemBinding
import com.example.newsapptask.model.FavoriteNews
import com.example.newsapptask.model.NewsItem

class FavoriteViewHolder(
    private val binding: ArticleItemBinding,
    private val listener: OnItemClickListener
) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(item: FavoriteNews) {
        binding.button.text = "Delete"
        binding.titleTextView.text = item.title
        binding.descriptionTextView.text = item.description
        binding.categoryOfArticleView.text = item.category
        binding.button.setOnClickListener { listener.onItemCLick(adapterPosition) }
    }
}