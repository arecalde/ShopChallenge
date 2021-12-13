package com.example.shopchallenge.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.example.shopchallenge.databinding.PageFragmentBinding

import androidx.recyclerview.widget.RecyclerView

import androidx.recyclerview.widget.LinearLayoutManager
import com.example.shopchallenge.page.OptionAdapter

class PageFragment : Fragment() {
    private val args: PageFragmentArgs by navArgs()

    private val viewModel: PageViewModel by viewModels {
        PageViewModelFactory(
            requireActivity().application,
            args.product
        )
    }
        override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View {
            val binding = PageFragmentBinding.inflate(inflater)
            binding.viewModel = viewModel
            binding.lifecycleOwner = viewLifecycleOwner

            val layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            val optionsRecycler = binding.options
            optionsRecycler.adapter = OptionAdapter(viewModel.options, viewLifecycleOwner)
            optionsRecycler.layoutManager = layoutManager

            return binding.root
        }

    }