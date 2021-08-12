package ru.mrwinwon.common

/**
 * Created by Artem Winokurov on 12.04.2021.
 * MrWinWon
* artem_winokurov@mail.ru
 */
object Utils {
    const val MAX_RETRIES = 3L
    private const val INITIAL_BACKOFF = 2000L

    fun getBackoffDelay(attempt: Long) = INITIAL_BACKOFF * (attempt + 1)
}