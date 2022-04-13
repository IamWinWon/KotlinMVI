package ru.mrwinwon.kotlinmvi.features.main

import kotlinx.coroutines.flow.collect
import ru.mrwinwon.kotlinmvi.common.BaseViewModel
import ru.mrwinwon.managers.MovieManager
import javax.inject.Inject

/**
 * Created by Artem Winokurov on 14.04.2021.
 * MrWinWon
 * artem_winokurov@mail.ru
 */
class MainViewModel @Inject constructor(private val dataManager: MovieManager) :
    BaseViewModel<MainIntent, MainAction, MainState>() {

    override fun handleAction(action: MainAction) {
        launchOnUI {
            when (action) {
                is MainAction.AllMovie -> {
                    dataManager.getAllMovies(1).collect {
                        localState.postValue(it.reduce())
                    }
                }
                is MainAction.Page -> {
                    dataManager.getAllMovies(action.page).collect {
                        localState.postValue(it.reduce())
                    }
                }
                is MainAction.SearchMovie -> {
                    dataManager.searchMovie(action.id).collect {
                        localState.postValue(it.reduce(true))
                    }
                }
            }
        }
    }

    override fun intentToAction(intent: MainIntent): MainAction {
        return when (intent) {
            is MainIntent.LoadAllMovies -> MainAction.AllMovie
            is MainIntent.ClearSearch -> MainAction.AllMovie
            is MainIntent.SearchMovie -> MainAction.SearchMovie(intent.id)
            is MainIntent.LoadPageMovies -> MainAction.Page(intent.page)
        }
    }
}