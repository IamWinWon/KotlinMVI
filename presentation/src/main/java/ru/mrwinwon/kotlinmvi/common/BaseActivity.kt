package ru.mrwinwon.kotlinmvi.common

import android.os.Bundle
import androidx.annotation.LayoutRes
import ru.mrwinwon.kotlinmvi.common.entities.*

/**
 * Created by Artem Winokurov on 13.04.2021.
 * MrWinWon
 * artem_winokurov@mail.ru
 */
abstract class BaseActivity<INTENT : ViewIntent, ACTION : ViewAction, STATE : ViewState,
        VM : BaseViewModel<INTENT, ACTION, STATE>>(private val modelClass: Class<VM>) :
    RootBaseActivity(),
    MyViewRender<STATE> {

    private lateinit var viewState: STATE
    val localState get() = viewState

    private val viewModel: VM by lazy {
        viewModelProvider(
            this.viewModelFactory,
            modelClass.kotlin
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutResId())
        initUI()
        viewModel.state.observe(this, {
            viewState = it
            render(it)
        })
        initDATA()
        initEVENT()
    }


    @LayoutRes
    abstract fun getLayoutResId(): Int
    abstract fun initUI()
    abstract fun initDATA()
    abstract fun initEVENT()
    fun dispatchIntent(intent: INTENT) {
        viewModel.dispatchIntent(intent)
    }
}