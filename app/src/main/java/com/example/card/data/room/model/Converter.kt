package com.example.card.data.room.model

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class Converter {

    @TypeConverter
    fun fromGroupTaskMemberList(value: List<CategoryModel>): String {
        val gson = Gson()
        val type = object : TypeToken<List<CategoryModel>>() {}.type
        return gson.toJson(value, type)
    }

    @TypeConverter
    fun toGroupTaskMemberList(value: String): List<CategoryModel> {
        val gson = Gson()
        val type = object : TypeToken<List<CategoryModel>>() {}.type
        return gson.fromJson(value, type)
    }
}