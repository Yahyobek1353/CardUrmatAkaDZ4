package com.example.card.data.room.dao

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.card.data.room.model.CardModel
import com.example.card.data.room.model.Converter

@Database(entities = [CardModel::class], version = 2)
@TypeConverters(Converter::class)
abstract class CardDatabase: RoomDatabase() {
    abstract fun getDao(): CardDao
}