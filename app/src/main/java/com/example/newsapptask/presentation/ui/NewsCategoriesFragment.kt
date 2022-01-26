package com.example.newsapptask.presentation.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager.VERTICAL
import com.example.newsapptask.R
import com.example.newsapptask.data.CategoriesSource
import com.example.newsapptask.databinding.FragmentNewsCategoriesBinding
import com.example.newsapptask.presentation.adapter.CategoriesAdapter
import com.example.newsapptask.presentation.adapter.OnItemClickListener
import com.example.newsapptask.presentation.viewModel.SharedViewModel

class NewsCategoriesFragment : Fragment(), OnItemClickListener {
    private var _binding: FragmentNewsCategoriesBinding? = null
    private val binding get() = _binding!!
    private val sharedViewModel: SharedViewModel by activityViewModels()
    private var categoryListAdapter: CategoriesAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentNewsCategoriesBinding.inflate(inflater, container, false)
        val dataSet = CategoriesSource.loadCategories()
        categoryListAdapter = context?.let { CategoriesAdapter(it, dataSet, this) }
        binding.categoryRecyclerView.apply {
            layoutManager = StaggeredGridLayoutManager(2, VERTICAL)
            adapter = categoryListAdapter
            setHasFixedSize(true)
        }
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onItemCLick(position: Int) {
        CategoriesSource.loadCategories()[position]?.let {
            sharedViewModel.selectCategory(requireContext().getString(it.nameSourceId))
        }
        findNavController().navigate(R.id.action_newsCategoriesFragment_to_articlesFragment)
    }
}
