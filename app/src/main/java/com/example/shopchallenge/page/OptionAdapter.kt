package com.example.shopchallenge.page

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.RecyclerView
import com.example.shopchallenge.R
import com.example.shopchallenge.databinding.DropdownBinding
import com.example.shopchallenge.model.Option

class OptionAdapter(private val items: List<Option>, private val lifecycleOwner: LifecycleOwner) : RecyclerView.Adapter<MyViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MyViewHolder {
        val itemBinding = DataBindingUtil.inflate<DropdownBinding>(
            LayoutInflater.from(parent.context),
            R.layout.dropdown,
            parent,
            false
        )
        return MyViewHolder(itemBinding, lifecycleOwner)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item: Option = items[position]
        holder.bind(item)
    }

    override fun getItemCount() = items.size
}

class MyViewHolder(private val binding: DropdownBinding, private val lifecycleOwner: LifecycleOwner) : RecyclerView.ViewHolder(binding.getRoot()) {

    fun bind(item: Option) {
        binding.lifecycleOwner = lifecycleOwner
        binding.option = item
        binding.executePendingBindings()
    }
}