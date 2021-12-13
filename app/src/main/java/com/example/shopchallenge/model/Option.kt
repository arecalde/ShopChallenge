package com.example.shopchallenge.model

import androidx.lifecycle.MutableLiveData
import java.io.Serializable

data class Option(
    val id: String,
    val name: String,
    val values: List<String>,
    var itemPosition: MutableLiveData<Int> = MutableLiveData(0)
): Serializable