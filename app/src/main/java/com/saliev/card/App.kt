package com.example.card

import android.app.Application
import androidx.room.Room
import com.example.card.data.room.dao.CardDatabase
import com.example.card.data.shared.Prefs

class App: Application() {

    companion object {
        lateinit var prefs: Prefs
        lateinit var database: CardDatabase

    }

    override fun onCreate() {
        super.onCreate()
        prefs = Prefs(this)
        database = Room.databaseBuilder(
            this,
            CardDatabase::class.java,
            "Room Android"
        ).allowMainThreadQueries().build()
    }
}