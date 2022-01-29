package com.example.newsapptask.presentation.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.coroutineScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.newsapptask.R
import com.example.newsapptask.databinding.FragmentArticlesBinding
import com.example.newsapptask.presentation.adapter.ArticlesAdapter
import com.example.newsapptask.presentation.viewModel.NewsViewModel
import com.example.newsapptask.presentation.viewModel.SharedViewModel
import java.util.*
import kotlinx.coroutines.launch

class ArticlesFragment : Fragment() {
    private var _binding: FragmentArticlesBinding? = null
    private val binding get() = _binding!!
    private val sharedViewModel: SharedViewModel by activityViewModels()
    private val newsViewModel: NewsViewModel by viewModels()
    private lateinit var articleAdapter : ArticlesAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentArticlesBinding.inflate(inflater, container, false)
        articleAdapter = ArticlesAdapter()
        binding.articleRecyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = articleAdapter
        }
        sharedViewModel.selectedCategory.value?.let {
            newsViewModel.getData(it.lowercase(Locale.getDefault()))
        }
        lifecycle.coroutineScope.launch {
            newsViewModel.items.observe(viewLifecycleOwner) {
                Log.i("ArticlesFragment", "newsList: $it")
                articleAdapter.submitList(it.data)
            }
        }
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
