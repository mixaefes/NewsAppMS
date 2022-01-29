package com.example.newsapptask.presentation.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.newsapptask.databinding.CategoryItemBinding
import com.example.newsapptask.model.Category

class CategoriesAdapter(
    private val context: Context,
    private val dataSet: List<Category>,
    private val listener : OnItemClickListener
) : RecyclerView.Adapter<CategoriesAdapter.CategoryViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = CategoryItemBinding.inflate(inflater, parent, false)
        return CategoryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        val item = dataSet[position]
        holder.textView.text = context.resources.getString(item.nameSourceId)
        holder.imageView.setImageResource(item.imageSourceId)
        holder.itemView.setOnClickListener { listener.onItemCLick(position) }
    }

    override fun getItemCount() = dataSet.size

    class CategoryViewHolder(binding: CategoryItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        val textView = binding.categoryTextView
        val imageView = binding.categoryImageView
    }

}
