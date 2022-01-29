package com.example.newsapptask.presentation.adapter

import androidx.recyclerview.widget.RecyclerView
import coil.api.load
import com.example.newsapptask.databinding.ArticleItemBinding
import com.example.newsapptask.model.NewsItem

class ArticleViewHolder(
    private val binding: ArticleItemBinding,
    private val listener: OnItemClickListener
) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(item: NewsItem) {
        binding.apply {
            titleTextView.text = item.title
            descriptionTextView.text = item.description
            categoryOfArticleView.text = item.category
            newsImageView.load(item.image)
            button.setOnClickListener { listener.onItemCLick(adapterPosition)}
        }
    }
}
