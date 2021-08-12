package ru.mrwinwon.common

/**
 * Created by Artem Winokurov on 12.04.2021.
 * MrWinWon
* artem_winokurov@mail.ru
 */
sealed class CallErrors {
    object ErrorEmptyData : CallErrors()
    object ErrorServer : CallErrors()
    data class ErrorException(val throwable: Throwable) : CallErrors()
}
