package com.tsci.factsonnumbers.domain.use_cases

import android.util.Log
import com.tsci.factsonnumbers.common.Resource
import com.tsci.factsonnumbers.data.repository.NumberFactsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

/*
    All use cases are holding here; holding every use case under a base use case will help a lot
    to reach them ( specific to this app; in other apps, it won't be a good idea probably).
 */
class UseCases @Inject constructor(
    private val repository: NumberFactsRepository
) {
    inner class GetTriviaInfoUseCase{
        operator fun invoke(number: String): Flow<Resource<String>> = flow {
            try {
                emit(Resource.Loading())
                val fact = repository.getTriviaInfoByNumber(number = number)
                Log.d("UseCases", fact)
                emit(Resource.Success(fact))
            } catch (e: HttpException) {
                Log.d("UseCases", "invoke: ${e.localizedMessage}")
                emit(Resource.Error(e.localizedMessage ?: "An unexpected error occured!"))
            } catch (e: IOException) {
                Log.d("UseCases", "invoke: ${e.localizedMessage}")
                emit(Resource.Error("Could not reach server, check your internet connection."))
            }
        }
    }

    inner class GetMathInfoUseCase{
        operator fun invoke(number: String): Flow<Resource<String>> = flow {
            try {
                emit(Resource.Loading())
                val fact = repository.getMathInfoByNumber(number = number)
                Log.d("UseCases", fact)
                emit(Resource.Success(fact))
            } catch (e: HttpException) {
                Log.d("UseCases", "invoke: ${e.localizedMessage}")
                emit(Resource.Error(e.localizedMessage ?: "An unexpected error occured!"))
            } catch (e: IOException) {
                Log.d("UseCases", "invoke: ${e.localizedMessage}")
                emit(Resource.Error("Could not reach server, check your internet connection."))
            }
        }
    }

    inner class GetDateInfoUseCase{
        operator fun invoke(day: String, month: String): Flow<Resource<String>> = flow {
            try {
                emit(Resource.Loading())
                val fact = repository.getDateInfoByNumber(day = day, month = month)
                Log.d("UseCases", fact)
                emit(Resource.Success(fact))
            } catch (e: HttpException) {
                Log.d("UseCases", "invoke: ${e.localizedMessage}")
                emit(Resource.Error(e.localizedMessage ?: "An unexpected error occured!"))
            } catch (e: IOException) {
                Log.d("UseCases", "invoke: ${e.localizedMessage}")
                emit(Resource.Error("Could not reach server, check your internet connection."))
            }
        }
    }

    inner class GetYearInfoUseCase{
        operator fun invoke(number: String): Flow<Resource<String>> = flow {
            try {
                emit(Resource.Loading())
                val fact = repository.getYearInfoByNumber(number = number)
                Log.d("UseCases", fact)
                emit(Resource.Success(fact))
            } catch (e: HttpException) {
                Log.d("UseCases", "invoke: ${e.localizedMessage}")
                emit(Resource.Error(e.localizedMessage ?: "An unexpected error occured!"))
            } catch (e: IOException) {
                Log.d("UseCases", "invoke: ${e.localizedMessage}")
                emit(Resource.Error("Could not reach server, check your internet connection."))
            }
        }
    }

    inner class GetRandomTriviaInfoUseCase{
        operator fun invoke(): Flow<Resource<String>> = flow {
            try {
                emit(Resource.Loading())
                val fact = repository.getRandomTriviaInfo()
                Log.d("UseCases", fact)
                emit(Resource.Success(fact))
            } catch (e: HttpException) {
                Log.d("UseCases", "invoke: ${e.localizedMessage}")
                emit(Resource.Error(e.localizedMessage ?: "An unexpected error occured!"))
            } catch (e: IOException) {
                Log.d("UseCases", "invoke: ${e.localizedMessage}")
                emit(Resource.Error("Could not reach server, check your internet connection."))
            }
        }
    }

    inner class GetRandomMathInfoUseCase{
        operator fun invoke(): Flow<Resource<String>> = flow {
            try {
                emit(Resource.Loading())
                val fact = repository.getRandomMathInfo()
                Log.d("UseCases", fact)
                emit(Resource.Success(fact))
            } catch (e: HttpException) {
                Log.d("UseCases", "invoke: ${e.localizedMessage}")
                emit(Resource.Error(e.localizedMessage ?: "An unexpected error occured!"))
            } catch (e: IOException) {
                Log.d("UseCases", "invoke: ${e.localizedMessage}")
                emit(Resource.Error("Could not reach server, check your internet connection."))
            }
        }
    }
    inner class GetRandomDateInfoUseCase{
        operator fun invoke(): Flow<Resource<String>> = flow {
            try {
                emit(Resource.Loading())
                val fact = repository.getRandomDateInfo()
                Log.d("UseCases", fact)
                emit(Resource.Success(fact))
            } catch (e: HttpException) {
                Log.d("UseCases", "invoke: ${e.localizedMessage}")
                emit(Resource.Error(e.localizedMessage ?: "An unexpected error occured!"))
            } catch (e: IOException) {
                Log.d("UseCases", "invoke: ${e.localizedMessage}")
                emit(Resource.Error("Could not reach server, check your internet connection."))
            }
        }
    }

    inner class GetRandomYearInfoUseCase{
        operator fun invoke(): Flow<Resource<String>> = flow {
            try {
                emit(Resource.Loading())
                val fact = repository.getRandomYearInfo()
                Log.d("UseCases", fact)
                emit(Resource.Success(fact))
            } catch (e: HttpException) {
                Log.d("UseCases", "invoke: ${e.localizedMessage}")
                emit(Resource.Error(e.localizedMessage ?: "An unexpected error occured!"))
            } catch (e: IOException) {
                Log.d("UseCases", "invoke: ${e.localizedMessage}")
                emit(Resource.Error("Could not reach server, check your internet connection."))
            }
        }
    }
}