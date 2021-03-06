package com.example.shopchallenge.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.RecyclerView
import com.example.shopchallenge.R
import com.example.shopchallenge.databinding.ItemCardBinding
import com.example.shopchallenge.model.Product
import com.example.shopchallenge.model.ProductWrapper

class ProductAdapter(private val items: List<ProductWrapper>, private val lifecycleOwner: LifecycleOwner) : RecyclerView.Adapter<MyViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MyViewHolder {
        val itemBinding = DataBindingUtil.inflate<ItemCardBinding>(
            LayoutInflater.from(parent.context),
            R.layout.item_card,
            parent,
            false
        )
        return MyViewHolder(itemBinding, lifecycleOwner)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item: ProductWrapper = items[position]
        holder.bind(item)
    }

    override fun getItemCount() = items.size
}

class MyViewHolder(private val binding: ItemCardBinding, private val lifecycleOwner: LifecycleOwner) : RecyclerView.ViewHolder(binding.getRoot()) {

    fun bind(item: ProductWrapper) {
        binding.lifecycleOwner = lifecycleOwner
        binding.product = item
        binding.executePendingBindings()
    }
}