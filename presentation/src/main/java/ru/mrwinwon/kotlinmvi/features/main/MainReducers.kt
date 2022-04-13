package ru.mrwinwon.kotlinmvi.features.main

import ru.mrwinwon.common.Result
import ru.mrwinwon.domain.entities.MovieLocal

/**
 * Created by Artem Winokurov on 14.04.2021.
 * MrWinWon
* artem_winokurov@mail.ru
 */

fun Result<List<MovieLocal>>.reduce(): MainState {
    return when (this) {
        is Result.Success -> {
            MainState.ResultAllMovies(data as MutableList<MovieLocal>)
        }
        is Result.Error -> MainState.Exception(errors)
        is Result.Loading -> MainState.Loading
        else -> MainState.Loading
    }
}

fun Result<MovieLocal>.reduce(isSearchMode: Boolean = true): MainState {
    return when (this) {
        is Result.Success -> {
            MainState.ResultSearch((data as MovieLocal).toMU)
        }
        is Result.Error -> MainState.Exception(errors)
        is Result.Loading -> MainState.Loading
        else -> MainState.Loading
    }
}