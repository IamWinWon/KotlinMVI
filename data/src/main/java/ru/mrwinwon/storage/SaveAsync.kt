package ru.mrwinwon.storage

/**
 * Created by Artem Winokurov on 12.03.2022.
 * MrWinWon
 * a.vinokurov@kingbird.ru
 */
interface SaveAsync<T> {
    fun saveAsync(data: T)
}