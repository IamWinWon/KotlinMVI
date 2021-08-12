package ru.mrwinwon.kotlinmvi.features.main

import ru.mrwinwon.common.CallErrors
import ru.mrwinwon.domain.entities.MovieLocal
import ru.mrwinwon.kotlinmvi.common.entities.ViewState

/**
 * Created by Artem Winokurov on 14.04.2021.
 * MrWinWon
* artem_winokurov@mail.ru
 */
sealed class MainState : ViewState {
    object Loading : MainState()
    data class ResultAllMovies(val data : MutableList<MovieLocal>) : MainState()
    data class ResultNextPageMovies(val data : MutableList<MovieLocal>) : MainState()
    data class ResultSearch(val data : MutableList<MovieLocal>) : MainState()
    data class Exception(val callErrors: CallErrors) : MainState()
}