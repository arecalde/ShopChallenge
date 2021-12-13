package com.example.shopchallenge.home

import android.app.Application
import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.lifecycle.*
import com.example.shopchallenge.model.Option
import com.example.shopchallenge.model.Product
import com.example.shopchallenge.model.SelectedOption
import com.example.shopchallenge.model.Variant
import com.squareup.picasso.Picasso

class PageViewModel(application: Application, val product: Product) : AndroidViewModel(application) {
    init {
        options.forEach {
            it.itemPosition = MutableLiveData(0)
        }
    }
    private val selectedOptions: Array<SelectedOption>
        get() = options.map {
            val selectedIndex = it.itemPosition.value ?: 0
            SelectedOption(it.name, it.values[selectedIndex])
        }.sortedBy { it.name }.toTypedArray()

    val variant = MediatorLiveData<Variant>().apply {
        fun selectVariant() {
            product.variants.forEach { variant ->
                val variantOptions = variant.selectedOptions.sortedBy { it.name }.toTypedArray()
                if (variantOptions.contentEquals(selectedOptions)) {
                    value = variant
                }
            }
        }

        options.forEach {
            addSource(it.itemPosition) { selectVariant() }
        }
    }

    fun buy() {
        val optionsString = variant.value?.selectedOptions?.joinToString(separator = "/") {
            it.value
        }

        println("$optionsString ${product.title}")
    }
    val options: List<Option>
        get() = product.options

    val priceAsString: String
        get() = "$${product.price}"
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