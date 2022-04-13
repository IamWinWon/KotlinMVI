package ru.mrwinwon.storage

/**
 * Created by Artem Winokurov on 08.03.2022.
 * MrWinWon
 * a.vinokurov@kingbird.ru
 */
interface Read<T> {
    fun read(): T
}