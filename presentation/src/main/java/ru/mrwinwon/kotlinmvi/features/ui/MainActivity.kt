package ru.mrwinwon.kotlinmvi.features.ui

import androidx.core.view.isVisible
import androidx.core.widget.doOnTextChanged
import kotlinx.android.synthetic.main.activity_main.*
import ru.mrwinwon.kotlinmvi.R
import ru.mrwinwon.kotlinmvi.common.BaseActivity
import ru.mrwinwon.kotlinmvi.common.getMessage
import ru.mrwinwon.kotlinmvi.common.runIfTrue
import ru.mrwinwon.kotlinmvi.features.main.MainAction
import ru.mrwinwon.kotlinmvi.features.main.MainIntent
import ru.mrwinwon.kotlinmvi.features.main.MainState
import ru.mrwinwon.kotlinmvi.features.main.MainViewModel

/**
 * Created by Artem Winokurov on 14.04.2021.
 * MrWinWon
* artem_winokurov@mail.ru
 */
class MainActivity : BaseActivity<MainIntent, MainAction, MainState, MainViewModel>(MainViewModel::class.java) {
    private val adapter = MovieAdapter()
    override fun getLayoutResId(): Int {
        return R.layout.activity_main
    }

    override fun initUI() {
        homeListCharacters.adapter = adapter
    }

    override fun initDATA() {
        dispatchIntent(MainIntent.LoadAllMovies)
    }

    override fun initEVENT() {
        homeSearchImage.setOnClickListener {
            homeSearchText.text.isNullOrBlank().not().runIfTrue {
                dispatchIntent(MainIntent.SearchMovie(1))
            }
        }
        homeSearchText.doOnTextChanged { text, _, _, _ ->
            text.isNullOrBlank()
                .and(localState is MainState.ResultSearch)
                .runIfTrue {
                    dispatchIntent(MainIntent.ClearSearch)
                }
        }
    }

    override fun render(state: MainState) {
        homeProgress.isVisible = state is MainState.Loading
        homeMessage.isVisible = state is MainState.Exception
        homeListCharacters.isVisible =
            state is MainState.ResultSearch || state is MainState.ResultAllMovies

        when (state) {
            is MainState.ResultAllMovies -> {
                adapter.updateList(state.data)
            }
            is MainState.ResultNextPageMovies -> {
                adapter.addToList(state.data)
            }
            is MainState.ResultSearch -> {
                adapter.updateList(state.data)
                // other logic ...
            }
            is MainState.Exception -> {
                homeMessage.text = state.callErrors.getMessage(this)
            }
        }
    }

}