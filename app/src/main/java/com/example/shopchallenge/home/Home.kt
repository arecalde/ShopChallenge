package com.example.shopchallenge.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.shopchallenge.databinding.HomeFragmentBinding

class Home : Fragment() {
    private val viewModel: HomeViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = HomeFragmentBinding.inflate(inflater)
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner

        viewModel.products.observe(viewLifecycleOwner) {
            binding.recyclerView.adapter = ProductAdapter(it, viewLifecycleOwner)
        }

        return binding.root
    }
}