package com.example.shopchallenge.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.shopchallenge.databinding.HomeFragmentBinding
import com.example.shopchallenge.model.ProductWrapper

class Home : Fragment() {
    private val viewModel: HomeViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = HomeFragmentBinding.inflate(inflater)
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner


        val observedItems = mutableListOf<String>()

        viewModel.products.observe(viewLifecycleOwner) { list ->
            val productList = list.map { ProductWrapper(it) }
            binding.recyclerView.adapter = ProductAdapter(productList, viewLifecycleOwner)

            productList.forEach { item ->
                if (observedItems.contains(item.product.id)) return@forEach

                item.goToPage.observeEvent(viewLifecycleOwner) {
                    findNavController().navigate(HomeDirections.actionHome2ToPhoto(item.product))
                }
                observedItems.add(item.product.id)
            }
        }

        return binding.root
    }
}