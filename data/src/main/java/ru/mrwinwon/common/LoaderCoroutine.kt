package ru.mrwinwon.common

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.retryWhen
import ru.mrwinwon.common.Utils.MAX_RETRIES
import ru.mrwinwon.common.Utils.getBackoffDelay
import java.io.IOException

/**
 * Created by Artem Winokurov on 12.04.2021.
 * MrWinWon
* artem_winokurov@mail.ru
 */

@ExperimentalCoroutinesApi
fun <T : Any> Flow<Result<T>>.applyCommonSideEffect() =
    retryWhen { cause, attempt ->
        when {
            (cause is IOException && attempt < MAX_RETRIES) -> {
                delay(getBackoffDelay(attempt))
                true
            }
            else -> {
                false
            }
        }
    }.onStart {
        emit(Result.Loading)
    }