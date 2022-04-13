package ru.mrwinwon.domain.entities

import java.io.Serializable

/**
 * Created by Artem Winokurov on 13.04.2021.
 * MrWinWon
* artem_winokurov@mail.ru
 */
data class MovieLocal(

    private val id: Int,
    private val id_kinopoisk: Int,
    private val url: String?,
    private val type: String?,
    val title: String?,
    private val title_alternative: String?,
    private val tagline: String?,
    private val description: String?,
    private val year: Int?,
    val poster: String?,
    private val trailer: String?,
    private val age: String?
): Serializable
