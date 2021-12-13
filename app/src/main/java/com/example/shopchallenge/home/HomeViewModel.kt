package com.example.shopchallenge.home

import android.app.Application
import android.content.Context
import androidx.appcompat.widget.SearchView
import androidx.databinding.BindingAdapter
import androidx.lifecycle.*
import com.example.shopchallenge.model.Product
import com.example.shopchallenge.model.Products
import com.google.gson.Gson

class HomeViewModel(application: Application) : AndroidViewModel(application) {
    private val _products = MutableLiveData(emptyList<Product>())
    val products: LiveData<List<Product>> = _products

    val productCount = products.map {
        it.size.toString()
    }
    init {
        _products.value = getProducts()
    }

    private val context: Context
        get() = getApplication<Application>().applicationContext

    private fun getProducts() : List<Product> {
        val rawData = context.assets.open("products.json").bufferedReader().use{
            it.readText()
        }

        val listData = Gson().fromJson(rawData, Products::class.java)
        return listData.products
    }
}

@BindingAdapter("queryTextListener")
fun setOnQueryTextListener(searchView: SearchView, listener: SearchView.OnQueryTextListener) {
    searchView.setOnQueryTextListener(listener);
}