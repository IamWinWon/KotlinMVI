package ru.mrwinwon.domain.dto

/**
 * Created by Artem Winokurov on 12.04.2021.
 * MrWinWon
* artem_winokurov@mail.ru
 */
data class Movies (

    val movies : List<MovieRemote>,
    val pagination : Pagination
)
