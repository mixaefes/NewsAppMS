package com.example.newsapptask.presentation.adapter

import androidx.recyclerview.widget.RecyclerView
import coil.api.load
import com.example.newsapptask.databinding.ArticleItemBinding
import com.example.newsapptask.model.FavoriteNews
import com.example.newsapptask.model.NewsItem

class FavoriteViewHolder(
    private val binding: ArticleItemBinding,
    private val listener: OnItemClickListener
) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(item: FavoriteNews) {
        binding.apply {
            button.text = "Delete"
            titleTextView.text = item.title
            descriptionTextView.text = item.description
            categoryOfArticleView.text = item.category
            newsImageView.load(item.image)
            button.setOnClickListener { listener.onItemCLick(adapterPosition) }
        }
    }
}