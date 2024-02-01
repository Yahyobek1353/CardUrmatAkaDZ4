package com.example.card.data.room.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters

@Entity
data class CardModel(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,
    val name: String,
    @TypeConverters(Converter::class)
    var list: List<CategoryModel>
)