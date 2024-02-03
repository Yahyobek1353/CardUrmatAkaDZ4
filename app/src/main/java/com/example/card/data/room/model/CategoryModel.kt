package com.example.card.data.room.model

import java.io.Serializable

data class CategoryModel(
    val name: ArrayList<CategoryModel>,
    val image: Int
): Serializable
