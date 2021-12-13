package com.example.shopchallenge.model

import com.example.shopchallenge.extensions.Event
import java.io.Serializable

data class Product(
    val id: String,
    val options: List<Option>,
    val price: Double,
    val selectedOptions: Any,
    val title: String,
    val variantBySelectedOptions: Any,
    val variants: List<Variant>
): Serializable

class ProductWrapper(val product: Product): Serializable {
    val goToPage = Event(Unit)

    fun triggerPageNav() {
        goToPage.raiseEvent(Unit)
    }

}