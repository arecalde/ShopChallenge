package com.example.shopchallenge.home

import android.app.Application
import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.shopchallenge.model.Product
import com.squareup.picasso.Picasso

class PageViewModel(application: Application, val product: Product) : AndroidViewModel(application) {
    // TODO: Implement the ViewModel
}

class PageViewModelFactory(private val application: Application, private val product: Product):
ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return PageViewModel(application, product) as T
    }
}

@BindingAdapter("imageUrl")
fun loadImage(view : View, url : String?){
    if (url.isNullOrEmpty()) return
    Picasso.get().load(url).into((view as ImageView))
}