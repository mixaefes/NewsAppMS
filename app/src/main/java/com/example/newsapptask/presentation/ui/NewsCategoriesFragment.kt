package com.example.newsapptask.presentation.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager.VERTICAL
import com.example.newsapptask.R
import com.example.newsapptask.data.CategoriesSource
import com.example.newsapptask.databinding.FragmentNewsCategoriesBinding
import com.example.newsapptask.presentation.adapter.CategoriesAdapter

class NewsCategoriesFragment : Fragment() {
    private var _binding: FragmentNewsCategoriesBinding? = null
    private val binding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentNewsCategoriesBinding.inflate(inflater, container, false)
        val dataSet = CategoriesSource().loadCategories()
        binding.categoryRecyclerView.layoutManager = StaggeredGridLayoutManager(2,VERTICAL)
        binding.categoryRecyclerView.adapter = context?.let { CategoriesAdapter(it,dataSet) }
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
