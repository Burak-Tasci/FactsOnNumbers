package com.tsci.factsonnumbers.data.repository

import com.tsci.factsonnumbers.data.remote.NumberFactsApi
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import javax.inject.Inject
/*
    Implementation of repository with api interface to be able to create repository functions
 */
class NumberFactsRepositoryImpl @Inject constructor(
    private val api: NumberFactsApi
): NumberFactsRepository{


    override suspend fun getTriviaInfoByNumber(number: String): String {
         return runBlocking {
                api.getTriviaInfoByNumber(number = number)
        }
    }

    override suspend fun getMathInfoByNumber(number: String): String {
        return runBlocking {
            api.getMathInfoByNumber(number = number)
        }
    }

    override suspend fun getDateInfoByNumber(month: String, day: String): String {
        return runBlocking {
            api.getDateInfoByNumber(month = month, day = day)
        }
    }

    override suspend fun getYearInfoByNumber(number: String): String {
        return runBlocking {
            api.getYearInfoByNumber(number = number)
        }
    }

    override suspend fun getRandomTriviaInfo(): String {
        return runBlocking {
            api.getRandomTriviaInfo()
        }
    }

    override suspend fun getRandomMathInfo(): String {
        return runBlocking {
            api.getRandomMathInfo()
        }
    }

    override suspend fun getRandomDateInfo(): String {
        return runBlocking {
            api.getRandomDateInfo()
        }
    }

    override suspend fun getRandomYearInfo(): String {
        return runBlocking {
            api.getRandomYearInfo()
        }
    }

}