package ru.mrwinwon.kotlinmvi.di.common

import ru.mrwinwon.kotlinmvi.common.RootBaseActivity
import ru.mrwinwon.kotlinmvi.di.annotations.ActivityScope
import javax.inject.Inject

/**
 * Created by Artem Winokurov on 13.04.2021.
 * MrWinWon
* artem_winokurov@mail.ru
 */
@ActivityScope
class AppRouter @Inject constructor(private val activity : RootBaseActivity)