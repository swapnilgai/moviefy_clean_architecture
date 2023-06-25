package com.example.moviefy_clean_architecture.common.ui

import androidx.fragment.app.Fragment
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch

abstract class BaseFragment<ContentT>: Fragment() {

    abstract val viewModel: BaseViewModel<ContentT>
    abstract fun render(contentT: ContentT)
    private var currentScope: CoroutineScope ? = null

    private fun observeEvent(){
        val scope = MainScope().also { currentScope = it }
        scope.launch {
            for(event in viewModel.uiChannel.observe(this)){
                when(event) {
                    is UiEvent.Content -> setContent(event.value)
                    is UiEvent.Loading -> setLoading(true)
                    is UiEvent.Error -> setError()
                    else -> {}
                }
            }
        }

    }

    private fun setContent(contentT: ContentT){
        setLoading(false)
        render(contentT)
    }

    private fun setLoading(boolean: Boolean){

    }

    private fun setError(){

    }

    override fun onDestroy() {
        super.onDestroy()
        currentScope?.cancel()
    }
}