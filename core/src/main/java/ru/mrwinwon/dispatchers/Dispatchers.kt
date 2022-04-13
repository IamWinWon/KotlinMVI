package ru.mrwinwon.dispatchers

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

/**
 * Created by Artem Winokurov on 13.04.2022.
 * MrWinWon
 * a.vinokurov@kingbird.ru
 */
interface Dispatchers {

    fun launchUI(scope: CoroutineScope, block: suspend CoroutineScope.() -> Unit): Job
    fun launchBackground(scope: CoroutineScope, block: suspend CoroutineScope.() -> Unit): Job
    suspend fun changeToUI(block: suspend CoroutineScope.() -> Unit)

    class Base : Dispatchers {
        override fun launchUI(
            scope: CoroutineScope,
            block: suspend CoroutineScope.() -> Unit
        ): Job = scope.launch(kotlinx.coroutines.Dispatchers.Main, block = block)

        override fun launchBackground(
            scope: CoroutineScope,
            block: suspend CoroutineScope.() -> Unit
        ): Job = scope.launch(kotlinx.coroutines.Dispatchers.IO, block = block)

        override suspend fun changeToUI(block: suspend CoroutineScope.() -> Unit) =
            withContext(kotlinx.coroutines.Dispatchers.Main, block)

    }
}