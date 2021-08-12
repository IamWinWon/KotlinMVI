package ru.mrwinwon.kotlinmvi.features.main

import ru.mrwinwon.kotlinmvi.common.entities.ViewAction

/**
 * Created by Artem Winokurov on 14.04.2021.
 * MrWinWon
* artem_winokurov@mail.ru
 */
sealed class MainAction : ViewAction {
    data class SearchMovie(val id: Long) : MainAction()
    data class Page(val page: Int) : MainAction()
    object AllMovie : MainAction()
}