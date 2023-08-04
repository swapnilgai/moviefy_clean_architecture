package com.example.moviefy_clean_architecture.common.ui

import android.os.Looper
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleCoroutineScope
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import androidx.lifecycle.lifecycleScope
import java.io.Serializable

fun <T> Fragment.viewScoped(initializer: () -> T) : LifecycleScopeLazy<T>{
    ensureMainThread()
    return LifecycleScopeLazyImpl(initializer) { viewLifecycleOwner.lifecycle }
}

interface LifecycleScopeLazy<out T> : Lazy<T>

internal class LifecycleScopeLazyImpl<out T>(
    private val initializer: () -> T,
    private val lifecycleProvider: () -> Lifecycle
): LifecycleScopeLazy<T>, Serializable {

    private var _value: Any? = UNINITILISED
    override val value: T
        get() {
            ensureMainThread()
            if(_value == UNINITILISED){
                val lifecycle = lifecycleProvider()
                check(lifecycle.currentState != Lifecycle.State.DESTROYED){
                    "Value must not access when its lifecycle destroyed"
                }
                _value = initializer()
                lifecycle.addObserver(
                    object : LifecycleObserver {
                        @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
                        fun onDestroy(){
                            _value = UNINITILISED
                        }
                    }
                )
            }
            @Suppress("UNCHECKED_CAST")
        return _value as T
        }

    override fun isInitialized(): Boolean {
        ensureMainThread()
        return _value !== UNINITILISED
    }
}


private val UNINITILISED = object : Any() {
//    override fun toString(): String = "Not Initilized"
}


val mainLooper: Looper by lazy { Looper.getMainLooper() }
val mainThread: Thread by lazy { mainLooper.thread }

fun ensureMainThread(
    lazyErrorMessage: (currentThread: Thread) -> String = { "Expected to run on main thread, but running on : $it" }
){
    val currentThread = Thread.currentThread()
    check(currentThread == mainThread) { lazyErrorMessage(currentThread) }
}