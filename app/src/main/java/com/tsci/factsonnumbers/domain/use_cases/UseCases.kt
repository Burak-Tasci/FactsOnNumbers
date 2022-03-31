package com.tsci.factsonnumbers.domain.use_cases

import androidx.lifecycle.viewModelScope
import com.tsci.factsonnumbers.common.Resource
import com.tsci.factsonnumbers.data.repository.NumberFactsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
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
                emit(Resource.Success(fact))
            } catch (e: HttpException) {
                emit(Resource.Error(e.localizedMessage ?: "An unexpected error occured!"))
            } catch (e: IOException) {
                emit(Resource.Error("Could not reach server, check your internet connection."))
            }
        }
    }
}