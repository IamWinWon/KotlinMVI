package ru.mrwinwon.kotlinmvi.di.module

import android.content.Context
import dagger.Module
import dagger.Provides
import ru.mrwinwon.kotlinmvi.KotlinMviApplication
import ru.mrwinwon.managers.MovieManager
import ru.mrwinwon.managers.MovieManagerImpl
import ru.mrwinwon.services.ApiService
import javax.inject.Singleton

/**
 * Created by Artem Winokurov on 13.04.2021.
 * MrWinWon
* artem_winokurov@mail.ru
 */
@Module
class ApplicationModule {
    @Provides
    fun provideApplicationContext(application : KotlinMviApplication) : Context = application.applicationContext

    @Provides
    @Singleton
    fun provideDataManagerAccessor(apiService: ApiService): MovieManager{
        return MovieManagerImpl(apiService)
    }
}