package com.example.moviefy_clean_architecture.common.ui

sealed class UiEvent<ContentT>{
    data class Content<ContentT>(
        val value: ContentT
    ) : UiEvent<ContentT>()
    object Loading : UiEvent<Nothing>()
    data class Error(val message: String): UiEvent<Nothing>()

}


