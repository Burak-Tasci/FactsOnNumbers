package com.tsci.factsonnumbers.data.repository

import com.tsci.factsonnumbers.data.remote.NumberFactsApi
import javax.inject.Inject

class NumberFactsRepositoryImpl @Inject constructor(
    private val api: NumberFactsApi
): NumberFactsRepository{
    override suspend fun getTriviaInfoByNumber(number: String): String {
        return api.getTriviaInfoByNumber(number = number)
    }

    override suspend fun getMathInfoByNumber(number: String): String {
        return api.getMathInfoByNumber(number = number)
    }

    override suspend fun getDateInfoByNumber(month: String, day: String): String {
        return api.getDateInfoByNumber(month = month, day = day)
    }

    override suspend fun getRandomTriviaInfo(): String {
        return api.getRandomTriviaInfo()
    }

    override suspend fun getRandomMathInfo(): String {
        return api.getRandomMathInfo()
    }

    override suspend fun getRandomDateInfo(): String {
        return api.getRandomDateInfo()
    }

    override suspend fun getRandomYearInfo(): String {
        return api.getRandomYearInfo()
    }

}