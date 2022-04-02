package com.tsci.factsonnumbers.data.repository

/*
    An interface to reach api without directly using it
 */
interface NumberFactsRepository {

    suspend fun getTriviaInfoByNumber(number: String): String

    suspend fun getMathInfoByNumber(number: String): String

    suspend fun getDateInfoByNumber(day: String, month: String): String

    suspend fun getYearInfoByNumber(number: String): String

    suspend fun getRandomTriviaInfo(): String

    suspend fun getRandomMathInfo(): String

    suspend fun getRandomDateInfo(): String

    suspend fun getRandomYearInfo(): String
}