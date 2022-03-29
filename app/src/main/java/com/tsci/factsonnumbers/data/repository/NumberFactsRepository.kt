package com.tsci.factsonnumbers.data.repository


interface NumberFactsRepository {

    suspend fun getTriviaInfoByNumber(number: String): String

    suspend fun getMathInfoByNumber(number: String): String

    suspend fun getDateInfoByNumber(month: String, day: String): String

    suspend fun getYearInfoByNumber(number: String): String

    suspend fun getRandomTriviaInfo(): String

    suspend fun getRandomMathInfo(): String

    suspend fun getRandomDateInfo(): String

    suspend fun getRandomYearInfo(): String
}