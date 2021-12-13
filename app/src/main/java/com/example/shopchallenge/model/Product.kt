package com.example.shopchallenge.model

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