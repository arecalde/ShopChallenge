package com.example.shopchallenge.model

import java.io.Serializable

data class Variant(
    val id: String,
    val image: String,
    val selectedOptions: List<SelectedOption>
): Serializable