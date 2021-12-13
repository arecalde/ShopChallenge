package com.example.shopchallenge.model

import java.io.Serializable

data class Option(
    val id: String,
    val name: String,
    val values: List<String>
): Serializable