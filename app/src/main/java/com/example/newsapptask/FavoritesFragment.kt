package com.example.newsapptask

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.coroutineScope
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.newsapptask.databinding.FragmentFavoritesBinding
import com.example.newsapptask.presentation.adapter.FavoritesAdapter
import com.example.newsapptask.presentation.adapter.OnItemClickListener
import com.example.newsapptask.presentation.viewModel.FavoriteNewsViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class FavoritesFragment : Fragment(), OnItemClickListener {
    private var _binding: FragmentFavoritesBinding? = null
    private val binding get() = _binding!!
    private lateinit var favoriteAdapter: FavoritesAdapter
    private val favoriteViewModel: FavoriteNewsViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentFavoritesBinding.inflate(inflater, container, false)
        favoriteAdapter = FavoritesAdapter(this)
        binding.favoritesRecyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = favoriteAdapter
        }
        lifecycle.coroutineScope.launch {
            favoriteViewModel.allFavoriteNewsList.observe(viewLifecycleOwner) {
                favoriteAdapter.submitList(it)
            }

        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onItemCLick(position: Int) {
        favoriteViewModel.deleteFavoriteNews(favoriteAdapter.currentList[position])
    }
}