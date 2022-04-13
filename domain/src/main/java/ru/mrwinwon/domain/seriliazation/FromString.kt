package ru.mrwinwon.domain.seriliazation

/**
 * Created by Artem Winokurov on 08.03.2022.
 * MrWinWon
 * a.vinokurov@kingbird.ru
 */
interface FromString {
    fun <T> fromString(data: String, clazz: Class<T>): T
}