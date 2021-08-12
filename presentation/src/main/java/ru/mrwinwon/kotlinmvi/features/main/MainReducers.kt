package ru.mrwinwon.kotlinmvi.features.main

import ru.mrwinwon.common.Result
import ru.mrwinwon.domain.entities.MovieLocal

/**
 * Created by Artem Winokurov on 14.04.2021.
 * MrWinWon
* artem_winokurov@mail.ru
 */

fun Result<List<MovieLocal>>.reduce(isSearchMode: Boolean = false): MainState {
    return when (this) {
        is Result.Success -> {
            if (isSearchMode) MainState.ResultSearch(data)
            else MainState.ResultAllMovies(data)
        }
        is Result.Error -> MainState.Exception(errors)
        is Result.Loading -> MainState.Loading
        else -> MainState.Loading
    }
}