package ru.mrwinwon.storage

import ru.mrwinwon.domain.entities.MovieLocal
import ru.mrwinwon.domain.seriliazation.Serialization
import ru.mrwinwon.domain.seriliazation.ToString
import java.io.Serializable

/**
 * Created by Artem Winokurov on 08.03.2022.
 * MrWinWon
 * a.vinokurov@kingbird.ru
 */
interface Storage<T> {

    interface Save<T> : ru.mrwinwon.storage.Save<T>
    interface Read<T> : ru.mrwinwon.storage.Read<T>
    interface Mutable<T>: Save<T>, Read<T>

    abstract class Base<T : Serializable>(
        private val stringStorage: StringStorage.Mutable,
        private val serializator: Serialization
    ) : Mutable<T> {

        abstract val clazz: Class<T>

        override fun read(): T {
            val string = stringStorage.read()
            return serializator.fromString(string, clazz)
        }

        override fun save(data: T) {
            val string = serializator.toString(data)
            stringStorage.save(string)
        }
    }

    interface MutableMovieLocal: Mutable<MovieLocal>
    class MovieLocalStorage(stringStorage: StringStorage.Mutable, serializator: Serialization) :
        Base<MovieLocal>(stringStorage, serializator), MutableMovieLocal {
        override val clazz: Class<MovieLocal> = MovieLocal::class.java
    }

}