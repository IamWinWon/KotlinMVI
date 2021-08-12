package ru.mrwinwon.kotlinmvi.common


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ru.mrwinwon.kotlinmvi.KotlinMviApplication
import ru.mrwinwon.kotlinmvi.di.common.AppRouter
import ru.mrwinwon.kotlinmvi.di.component.ActivityComponent
import ru.mrwinwon.kotlinmvi.di.component.DaggerActivityComponent
import ru.mrwinwon.kotlinmvi.di.module.ActivityModule
import ru.mrwinwon.kotlinmvi.di.viewmodels.DaggerViewModelFactory
import javax.inject.Inject

/**
 * Created by Artem Winokurov on 14.04.2021.
 * MrWinWon
* artem_winokurov@mail.ru
 */
open class RootBaseActivity : AppCompatActivity() {

    private val activityComponent: ActivityComponent by lazy {
        DaggerActivityComponent.builder().activityModule(ActivityModule(this))
            .applicationComponent(KotlinMviApplication.appComponents).build()
    }

    @Inject
    lateinit var appRouter: AppRouter

    @Inject
    lateinit var viewModelFactory: DaggerViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        activityComponent.inject(this)
        super.onCreate(savedInstanceState)
    }
}