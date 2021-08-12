package ru.mrwinwon.common

/**
 * Created by Artem Winokurov on 12.04.2021.
 * MrWinWon
* artem_winokurov@mail.ru
 */
sealed class Result<out T : Any> {
    data class Success<out T : Any>(val data: T) : Result<T>()
    data class Error(val errors: CallErrors) : Result<Nothing>()
    object Loading : Result<Nothing>()
}
