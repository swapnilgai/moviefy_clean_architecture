package com.example.moviefy_clean_architecture.network.module.model

data class Result(
     val id : Int,
     val page: Int,
     val total_results : Int,
     val total_pages : Int,
     val results: ArrayList<Movies>?
)