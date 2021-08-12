package ru.mrwinwon.kotlinmvi.common.entities

/**
 * Created by Artem Winokurov on 13.04.2021.
 * MrWinWon
* artem_winokurov@mail.ru
 */
interface MyReducer<STATE, T : Any> {
    fun reduce(result: Result<T>, state: STATE): STATE
}