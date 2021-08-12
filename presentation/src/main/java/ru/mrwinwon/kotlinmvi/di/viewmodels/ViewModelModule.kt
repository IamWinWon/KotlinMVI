package ru.mrwinwon.kotlinmvi.di.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import ru.mrwinwon.kotlinmvi.di.annotations.ViewModelKey
import ru.mrwinwon.kotlinmvi.features.main.MainViewModel

/**
 * Created by Artem Winokurov on 14.04.2021.
 * MrWinWon
* artem_winokurov@mail.ru
 */
@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    abstract fun bindMainViewModel(mainViewModel: MainViewModel): ViewModel

    @Binds
    abstract fun bindViewModelFactory(factory: DaggerViewModelFactory): ViewModelProvider.Factory
}