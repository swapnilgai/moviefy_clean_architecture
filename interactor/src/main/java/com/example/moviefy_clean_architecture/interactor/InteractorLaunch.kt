package com.example.moviefy_clean_architecture.interactor

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext

val clearCache = CacheCoroutineContextElement(setCache = false)

fun CoroutineScope.InteractorLaunch(
    context: CoroutineContext = EmptyCoroutineContext,
   start: CoroutineStart = CoroutineStart.DEFAULT,
   forceRefresh: Boolean = false,
   block: CoroutineScope.() -> Unit
) : Job {
    return if(forceRefresh)
        launch(context, start, block)
    else {
       val newContext =  clearCache + this.coroutineContext + context
       launch(newContext, start, block)
    }
}