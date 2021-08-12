package ru.mrwinwon.domain.dto

import ru.mrwinwon.domain.entities.MovieLocal

/**
 * Created by Artem Winokurov on 12.04.2021.
 * MrWinWon
 * marriedmrsleep@gmail.com
 */

data class MovieRemote(

    val id: Int,
    val id_kinopoisk: Int,
    val url: String,
    val type: String,
    val title: String,
    val title_alternative: String,
    val tagline: String,
    val description: String,
    val year: Int,
    val poster: String,
    val trailer: String,
    val age: String,
    val actors: List<String>,
    val countries: List<String>,
    val genres: List<String>,
    val directors: List<String>,
    val screenwriters: List<String>,
    val producers: List<String>,
    val operators: List<String>,
    val composers: List<String>,
    val painters: List<String>,
    val editors: List<String>,
    val budget: String,
    val rating_kinopoisk: Double,
    val rating_imdb: Double,
    val kinopoisk_votes: Int,
    val imdb_votes: Int,
    val fees_world: String,
    val fees_russia: String,
    val premiere_world: String,
    val premiere_russia: String,
    val frames: List<String>,
    val screenshots: List<String>,
//    val videocdn: List<Videocdn>,
//    val hdvb: Hdvb,
//    val collapse: Collapse,
//    val kodik: Kodik
)

fun MovieRemote.toModel() =
    MovieLocal(
        id,
        id_kinopoisk,
        url,
        type,
        title,
        title_alternative,
        tagline,
        description,
        year,
        poster,
        trailer,
        age
    )

fun List<MovieRemote>.toModel() = map { it.toModel() }