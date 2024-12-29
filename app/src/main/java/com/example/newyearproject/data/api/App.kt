package com.example.newyearproject.data.api

import android.app.Application
import androidx.room.Room
import com.example.newyearproject.data.db.SearchDatabase
import com.example.newyearproject.data.db.UsersDatabase


class App : Application() {
    override fun onCreate() {
        super.onCreate()

/* База данных для пользователей с гитхаба */

        db_user = Room.databaseBuilder(
            applicationContext, // Контекст приложения
            UsersDatabase::class.java, // Используемый класс для работы с бд
            "user-db"
        ).allowMainThreadQueries().build()

/* База данных для поисковых запросов с гитхаба с гитхаба */

        db_search = Room.databaseBuilder(
            applicationContext,
            SearchDatabase::class.java,
            "search-db"
        ).allowMainThreadQueries().build()
    }

    companion object {
        var db_user: UsersDatabase? = null
        fun getDatabase_Users(): UsersDatabase? {
            return db_user
        }

        var db_search: SearchDatabase? = null
        fun getDatabase_Search(): SearchDatabase? {
            return db_search
        }
    }
}
