package ru.mrwinwon.domain.entities

/**
 * Created by Artem Winokurov on 13.04.2021.
 * MrWinWon
* artem_winokurov@mail.ru
 */
data class MovieLocal(

    val id: Int,
    val id_kinopoisk: Int,
    val url: String?,
    val type: String?,
    val title: String?,
    val title_alternative: String?,
    val tagline: String?,
    val description: String?,
    val year: Int?,
    val poster: String?,
    val trailer: String?,
    val age: String?
)
