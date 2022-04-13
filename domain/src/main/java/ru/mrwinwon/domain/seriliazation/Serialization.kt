package ru.mrwinwon.domain.seriliazation

import com.google.gson.Gson

/**
 * Created by Artem Winokurov on 08.03.2022.
 * MrWinWon
 * a.vinokurov@kingbird.ru
 */
interface Serialization: FromString, ToString {

    class Base(private val gson: Gson): Serialization {
        override fun <T> toString(data: T): String {
            return gson.toJson(data)
        }

        override fun <T> fromString(data: String, clazz: Class<T>): T {
            return gson.fromJson(data, clazz)
        }
    }
}