package ru.mrwinwon.kotlinmvi.common

import android.os.Bundle
import android.view.View
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment

/**
 * Created by Artem Winokurov on 14.04.2021.
 * MrWinWon
* artem_winokurov@mail.ru
 */
abstract class BaseFragment(@LayoutRes val layoutId: Int) : Fragment(layoutId) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initView()
        initData()
        super.onViewCreated(view, savedInstanceState)
    }

    abstract fun initView()
    abstract fun initData()
}