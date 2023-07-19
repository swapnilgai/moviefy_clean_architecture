package com.example.moviefy_clean_architecture.common.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch

abstract class BaseFragment<ContentT>: Fragment() {

    @get:LayoutRes abstract val layoutId: Int

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

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val root = inflater.inflate(R.layout.fragment_base, container, false)

        return super.onCreateView(inflater, container, savedInstanceState)
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