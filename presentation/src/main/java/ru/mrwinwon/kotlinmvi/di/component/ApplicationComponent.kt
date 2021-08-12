package ru.mrwinwon.kotlinmvi.di.component

import dagger.BindsInstance
import dagger.Component
import ru.mrwinwon.kotlinmvi.KotlinMviApplication
import ru.mrwinwon.kotlinmvi.di.annotations.ViewModelKey
import ru.mrwinwon.kotlinmvi.di.module.ApplicationModule
import ru.mrwinwon.kotlinmvi.di.module.NetworkModule
import ru.mrwinwon.kotlinmvi.di.viewmodels.DaggerViewModelFactory
import ru.mrwinwon.kotlinmvi.di.viewmodels.ViewModelModule
import javax.inject.Singleton

/**
 * Created by Artem Winokurov on 13.04.2021.
 * MrWinWon
* artem_winokurov@mail.ru
 */

@Singleton
@Component(modules = [ApplicationModule::class, NetworkModule::class, ViewModelModule::class])
interface ApplicationComponent {

    @Component.Builder
    interface Builder {
        fun build(): ApplicationComponent

        @BindsInstance
        fun application(application: KotlinMviApplication): Builder
    }

    fun provideDaggerViewModelFactory(): DaggerViewModelFactory
}