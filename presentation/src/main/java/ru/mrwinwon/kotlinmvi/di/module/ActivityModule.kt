package ru.mrwinwon.kotlinmvi.di.module

import android.content.Context
import dagger.Module
import dagger.Provides
import ru.mrwinwon.kotlinmvi.common.RootBaseActivity
import ru.mrwinwon.kotlinmvi.di.common.AppRouter
import ru.mrwinwon.managers.MovieManager
import ru.mrwinwon.managers.MovieManagerImpl
import ru.mrwinwon.services.ApiService

/**
 * Created by Artem Winokurov on 13.04.2021.
 * MrWinWon
* artem_winokurov@mail.ru
 */
@Module
class ActivityModule constructor(private val activity: RootBaseActivity) {

    @Provides
    fun provideActivityContext(): Context = activity.application

    @Provides
    fun provideActivity(): RootBaseActivity { return activity }

    @Provides
    fun provideRouterComponent() : AppRouter = AppRouter(activity)

    @Provides
    fun provideMovieManager(apiService: ApiService) : MovieManager {
        return MovieManagerImpl(apiService)
    }

}