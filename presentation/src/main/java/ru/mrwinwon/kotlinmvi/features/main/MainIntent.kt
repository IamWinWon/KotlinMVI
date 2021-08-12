package ru.mrwinwon.kotlinmvi.features.main

import ru.mrwinwon.kotlinmvi.common.entities.ViewIntent

/**
 * Created by Artem Winokurov on 14.04.2021.
 * MrWinWon
* artem_winokurov@mail.ru
 */
sealed class MainIntent : ViewIntent {
    object LoadAllMovies : MainIntent()
    data class SearchMovie(val id: Long) : MainIntent()
    data class LoadPageMovies(val page: Int) : MainIntent()
    object ClearSearch : MainIntent()
}