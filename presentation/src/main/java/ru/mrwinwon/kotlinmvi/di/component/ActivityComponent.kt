package ru.mrwinwon.kotlinmvi.di.component

import dagger.Component
import ru.mrwinwon.kotlinmvi.common.RootBaseActivity
import ru.mrwinwon.kotlinmvi.di.annotations.ActivityScope
import ru.mrwinwon.kotlinmvi.di.common.AppRouter
import ru.mrwinwon.kotlinmvi.di.module.ActivityModule

/**
 * Created by Artem Winokurov on 13.04.2021.
 * MrWinWon
* artem_winokurov@mail.ru
 */
@ActivityScope
@Component(modules = [ActivityModule::class], dependencies = [ApplicationComponent::class])
interface ActivityComponent {
    fun inject(baseActivity: RootBaseActivity)
    fun appRouter(): AppRouter
}