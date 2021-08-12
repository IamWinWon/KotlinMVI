package ru.mrwinwon.domain.dto

/**
 * Created by Artem Winokurov on 12.04.2021.
 * MrWinWon
* artem_winokurov@mail.ru
 */
data class Pagination (

    val current_page : String,
    val end_page : String,
    val total_pages : Int
)
