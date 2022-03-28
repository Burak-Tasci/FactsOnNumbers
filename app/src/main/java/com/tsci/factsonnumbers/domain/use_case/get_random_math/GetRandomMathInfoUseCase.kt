package com.tsci.factsonnumbers.domain.use_case.get_random_math


import com.tsci.factsonnumbers.common.Resource
import com.tsci.factsonnumbers.data.repository.NumberFactsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetRandomMathInfoUseCase @Inject constructor(
    private val repository: NumberFactsRepository
){
    operator fun invoke(): Flow<Resource<String>> = flow {
        try {
            emit(Resource.Loading())
            val info = repository.getRandomMathInfo()
            emit(Resource.Success(info))
        }catch (e: HttpException){
            emit(Resource.Error(e.localizedMessage?: "An unexpected error occured!"))
        }catch (e: IOException){
            emit(Resource.Error("Could not reach server, check your internet connection."))
        }
    }
}