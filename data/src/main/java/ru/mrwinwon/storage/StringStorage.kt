package ru.mrwinwon.storage

import android.content.Context

/**
 * Created by Artem Winokurov on 08.03.2022.
 * MrWinWon
 * a.vinokurov@kingbird.ru
 */
interface StringStorage {

    interface Save : Storage.Save<String>
    interface Read : Storage.Read<String>

    interface Mutable : Save, Read

    class Base(context: Context, private val key: String) : Mutable {

        companion object {
            const val STORAGE_NAME = "KotlinMVI"
        }

        private val sharedPreferences = context.getSharedPreferences(
            STORAGE_NAME,
            Context.MODE_PRIVATE
        )

        override fun read(): String {
            return sharedPreferences.getString(key, "default") ?: "default"
        }

        override fun save(data: String) {
            sharedPreferences.edit().putString(key, data).apply()
        }

    }

    // TODO: 08.03.2022 room
}