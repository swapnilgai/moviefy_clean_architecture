package com.example.moviefy_clean_architecture.network.module.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

class Movies : Serializable {
    val original_name: String? = null
    val name: String? = null
    val first_air_date: String? = null
    val vote_count = 0
    val id = 0
    val isVideo = false
    val vote_average = 0f
    val title: String? = null
    val popularity = 0f
    val poster_path: String? = null
    val original_language: String? = null
    val original_title: String? = null
    val backdrop_path: String? = null
    val isAdult = false
    val overview: String? = null
    val release_date: String? = null
}