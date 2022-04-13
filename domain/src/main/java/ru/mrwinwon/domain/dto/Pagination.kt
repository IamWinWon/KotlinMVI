package ru.mrwinwon.domain.dto

/**
 * Created by Artem Winokurov on 12.04.2021.
 * MrWinWon
* artem_winokurov@mail.ru
 */
data class Pagination (

    private val current_page : String,
    private val end_page : String,
    private val total_pages : Int
)
