package com.example.moviefy_clean_architecture.interactor

import okhttp3.ResponseBody
import retrofit2.HttpException
import retrofit2.Response
import java.io.IOException

sealed class InteracroeException : Exception() {
    abstract override val message: String
    sealed class HTTP: InteracroeException() {
        abstract val response: Response<*>
        data class ServerError internal constructor(override val message: String,
                                                          override val response: Response<*>): HTTP()

        data class Unauthorize internal constructor(override val message: String,
                                                    override val response: Response<*>): HTTP()
    }
    data class Generic constructor(override val message: String): InteracroeException()
}

fun Exception.toInteractorException(): InteracroeException {
    return when(this){
        is HttpException -> toInteractorException(
            Response.error<Any?>(this.code(), ResponseBody.create(null, ""))
        )
        else -> InteracroeException.Generic(message = this.message?: "Something wen wrong")
    }
}

//TODO add this strings to string.xml
fun toInteractorException(response: Response<*>): InteracroeException =
    when(response.code()){
        500, 503 ->  InteracroeException.HTTP.ServerError(message = response.message()?: "Internal Server error", response = response)
        401 ->  InteracroeException.HTTP.Unauthorize(message = response.message()?: "Your not authorized", response = response)
        else -> InteracroeException.Generic(message = response.message()?: "Something wen wrong")
    }
