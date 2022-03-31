package com.tsci.factsonnumbers.data.remote

import retrofit2.http.GET
import retrofit2.http.Path
/*
    Declaration of api requests
 */
interface NumberFactsApi {

    @GET("/{number}")
    suspend fun getTriviaInfoByNumber(@Path(value = "number") number: String): String

    @GET("/{number}/math")
    suspend fun getMathInfoByNumber(@Path(value = "number") number: String): String

    @GET(value = "/{month}/{day}/date")
    suspend fun getDateInfoByNumber(
        @Path(value = "month") month: String,
        @Path(value = "day") day: String
    ): String

    @GET("/{number}/year")
    suspend fun getYearInfoByNumber(@Path(value = "number") number: String): String

    @GET(value = "/random/trivia")
    suspend fun getRandomTriviaInfo(): String

    @GET(value = "/random/math")
    suspend fun getRandomMathInfo(): String

    @GET(value = "/random/date")
    suspend fun getRandomDateInfo(): String

    @GET(value = "/random/year")
    suspend fun getRandomYearInfo(): String

}