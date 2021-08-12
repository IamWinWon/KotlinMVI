package ru.mrwinwon.kotlinmvi

import android.app.Application
import ru.mrwinwon.kotlinmvi.di.component.ApplicationComponent
import ru.mrwinwon.kotlinmvi.di.component.DaggerApplicationComponent

/**
 * Created by Artem Winokurov on 13.04.2021.
 * MrWinWon
* artem_winokurov@mail.ru
 */
class KotlinMviApplication: Application() {

    companion object {
        lateinit var appComponents: ApplicationComponent
    }

    override fun onCreate() {
        super.onCreate()
        appComponents = initDagger()
    }

    private fun initDagger(): ApplicationComponent =
        DaggerApplicationComponent.builder().application(this).build()

}