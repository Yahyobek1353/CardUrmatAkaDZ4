package com.example.card.data.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.card.data.room.model.CardModel

@Dao
interface CardDao {

    @Query("SELECT * FROM cardModel")
    fun getAllCard(): List<CardModel>


    @Insert
    fun insertCard(model: CardModel)

    @Update
    fun updateCard(model: CardModel)
}