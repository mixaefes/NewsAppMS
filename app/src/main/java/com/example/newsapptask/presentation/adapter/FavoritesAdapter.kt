package com.example.newsapptask.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.example.newsapptask.databinding.ArticleItemBinding
import com.example.newsapptask.model.FavoriteNews
import com.example.newsapptask.model.NewsItem

class FavoritesAdapter(
    private val listener: OnItemClickListener
): ListAdapter<FavoriteNews, FavoriteViewHolder>(itemComparator)  {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ArticleItemBinding.inflate(inflater, parent, false)
        return FavoriteViewHolder(binding,listener)
    }

    override fun onBindViewHolder(holder: FavoriteViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    companion object {
        val itemComparator = object : DiffUtil.ItemCallback<FavoriteNews>() {
            override fun areItemsTheSame(oldItem: FavoriteNews, newItem: FavoriteNews): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: FavoriteNews, newItem: FavoriteNews): Boolean {
                return oldItem.title == newItem.title
            }

        }
    }
}
