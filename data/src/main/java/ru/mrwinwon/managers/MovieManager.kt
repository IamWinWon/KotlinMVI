package ru.mrwinwon.managers

import kotlinx.coroutines.flow.Flow
import ru.mrwinwon.domain.dto.MovieRemote
import ru.mrwinwon.domain.dto.Movies
import ru.mrwinwon.common.Result
import ru.mrwinwon.domain.entities.MovieLocal

/**
 * Created by Artem Winokurov on 13.04.2021.
 * MrWinWon
* artem_winokurov@mail.ru
 */
interface MovieManager {
    fun getAllMovies(page: Int): Flow<Result<List<MovieLocal>>>
    fun searchMovie(id: Long): Flow<Result<MovieRemote>>
    fun getAllTVSeries(page: Int): Flow<Result<List<MovieRemote>>>
}