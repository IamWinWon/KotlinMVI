package ru.mrwinwon.kotlinmvi.common

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import ru.mrwinwon.kotlinmvi.common.entities.MyModel
import ru.mrwinwon.kotlinmvi.common.entities.ViewAction
import ru.mrwinwon.kotlinmvi.common.entities.ViewIntent
import ru.mrwinwon.kotlinmvi.common.entities.ViewState

/**
 * Created by Artem Winokurov on 13.04.2021.
 * MrWinWon
* artem_winokurov@mail.ru
 */
abstract class BaseViewModel<INTENT : ViewIntent, ACTION : ViewAction, STATE : ViewState> :
    ViewModel(),
    MyModel<STATE, INTENT> {

    protected val localState = MutableLiveData<STATE>()

    override val state: LiveData<STATE>
        get() {
            return localState
        }

    fun launchOnUI(block: suspend CoroutineScope.() -> Unit) {
        viewModelScope.launch { block() }
    }

    final override fun dispatchIntent(intent: INTENT) {
        handleAction(intentToAction(intent))
    }

    abstract fun intentToAction(intent: INTENT): ACTION
    abstract fun handleAction(action: ACTION)


}