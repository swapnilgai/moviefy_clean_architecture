package com.example.moviefy_clean_architecture.common.ui

import android.content.res.Resources
import androidx.lifecycle.ViewModel
import com.example.moviefy_clean_architecture.interactor.InteracroeException
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

abstract class BaseViewModel<ContentT>(initialContent: ContentT): ViewModel(), KoinComponent {

    private val resource: Resources by inject()
    abstract fun render(content: ContentT)

    val uiChannel = UiChannelImpl(initialContent)

    private val coroutineExceptionHandler = CoroutineExceptionHandler { coroutineContext, throwable ->
        when(throwable) {
            is InteracroeException.HTTP.ServerError -> shoeDialog(
                resource.getString(org.koin.android.R.string.abc_action_bar_home_description)
            )
            is InteracroeException.HTTP.Unauthorize -> shoeDialog(
                resource.getString(org.koin.android.R.string.abc_action_bar_home_description)
            )
            is InteracroeException.Generic -> shoeDialog(
                resource.getString(org.koin.android.R.string.abc_action_bar_home_description)
            )
        }
    }

    protected val viewModelScope = CoroutineScope(
        SupervisorJob() + Dispatchers.Main + coroutineExceptionHandler
    )
    private fun setContent(content: ContentT){
        uiChannel.setContent(content)
    }
    private fun shoeDialog(message: String){}
}