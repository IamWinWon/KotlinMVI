package ru.mrwinwon.managers

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import ru.mrwinwon.common.CallErrors
import ru.mrwinwon.data.BuildConfig
import ru.mrwinwon.domain.dto.MovieRemote
import ru.mrwinwon.services.ApiService
import ru.mrwinwon.common.Result
import ru.mrwinwon.common.applyCommonSideEffect
import ru.mrwinwon.domain.dto.toModel
import ru.mrwinwon.domain.entities.MovieLocal


/**
 * Created by Artem Winokurov on 13.04.2021.
 * MrWinWon
* artem_winokurov@mail.ru
 */
class MovieManagerImpl(private val apiService: ApiService) : MovieManager {
    override fun getAllMovies(page: Int): Flow<Result<List<MovieLocal>>> = flow {
        apiService.getMovies(page, BuildConfig.API_TOKEN).run {
            if (this.isSuccessful) {
                if (this.body() == null) {
                    emit(Result.Error(CallErrors.ErrorEmptyData))
                } else {
                    emit(Result.Success(this.body()!!.movies.toModel()))
                }
            } else {
                emit(Result.Error(CallErrors.ErrorServer))
            }
        }
    }.applyCommonSideEffect().catch {
        emit(Result.Error(CallErrors.ErrorException(it)))
    }

    override fun searchMovie(id: Long): Flow<Result<MovieRemote>> {
        TODO("Not yet implemented")
    }

    override fun getAllTVSeries(page: Int): Flow<Result<List<MovieRemote>>> {
        TODO("Not yet implemented")
    }
}