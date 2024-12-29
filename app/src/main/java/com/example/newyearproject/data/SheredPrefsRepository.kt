package com.example.newyearproject.data

import android.content.Context
import android.content.SharedPreferences

// В данном классе реализуется SharedPrefs,
// который хранит данные приложения в кеше,
// увы, если кэш почистить,
// от эти данные сотрутся,
// крч самая примитивная БДшка.

class SharedPrefsRepository(
    context: Context,
    /* Контекст необходим для получения ресурсов из приложения, он
       существует в течении жизненого цикла всего приложения на устройстве */
) {

    private val prefs: SharedPreferences =
        context.getSharedPreferences("SHARED_PREFS", Context.MODE_PRIVATE)

    // Переменые + гетеры + сетеры
    var username: String
        get() {
            return prefs.getString(USERNAME_KEY, "") ?: ""
        }
        set(value) {
            prefs.edit().putString(USERNAME_KEY, value).apply()
        }

    var name: String
        get() {
            return prefs.getString(NAME_KEY, "") ?: ""
        }
        set(value) {
            prefs.edit().putString(NAME_KEY, value).apply()
        }

    var lastname: String
        get() {
            return prefs.getString(LASTNAME_KEY, "") ?: ""
        }
        set(value) {
            prefs.edit().putString(LASTNAME_KEY, value).apply()
        }

    var age: Int
        get() {
            return prefs.getInt(AGE_KEY, 0) ?: 0
        }
        set(value) {
            prefs.edit().putInt(AGE_KEY, value).apply()
        }


    companion object { // Иницлизация констант
        private const val USERNAME_KEY = "USERNAME"
        private const val NAME_KEY = "NAME"
        private const val LASTNAME_KEY = "LASTNAME"
        private const val AGE_KEY = "AGE"
    }
}