package com.tsci.factsonnumbers.presentation.fact_detail

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tsci.factsonnumbers.common.ApiWay
import com.tsci.factsonnumbers.common.Resource
import com.tsci.factsonnumbers.domain.use_cases.UseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class FactDetailViewModel @Inject constructor(
    private val useCases: UseCases
) : ViewModel() {
    private val _state = mutableStateOf(FactDetailState())
    val state: State<FactDetailState> = _state


    fun getTriviaInfoByNumber(number: String) {
        useCases.GetTriviaInfoUseCase().invoke(number = number).onEach { result ->
            when (result) {

                is Resource.Loading -> {
                    _state.value = FactDetailState(isLoading = true)
                }
                is Resource.Success -> {
                    _state.value = FactDetailState(fact = result.data.toString())
                }
                is Resource.Error -> FactDetailState(
                    error = result.message ?: "An unexpected error occurred"
                )
            }
        }.launchIn(viewModelScope)
    }

    fun getMathInfoByNumber(year: String) {
        useCases.GetMathInfoUseCase().invoke(number = year).onEach { result ->
            when (result) {

                is Resource.Loading -> {
                    _state.value = FactDetailState(isLoading = true)
                }
                is Resource.Success -> {
                    _state.value = FactDetailState(fact = result.data.toString())
                }
                is Resource.Error -> FactDetailState(
                    error = result.message ?: "An unexpected error occurred"
                )
            }
        }.launchIn(viewModelScope)
    }

    fun getDateInfoByNumber(month: String, day: String) {
        useCases.GetDateInfoUseCase().invoke(
            month = month,
            day = day
        ).onEach { result ->
            when (result) {

                is Resource.Loading -> {
                    _state.value = FactDetailState(isLoading = true)
                }
                is Resource.Success -> {
                    _state.value = FactDetailState(fact = result.data.toString())
                }
                is Resource.Error -> FactDetailState(
                    error = result.message ?: "An unexpected error occurred"
                )
            }
        }.launchIn(viewModelScope)
    }

    fun getYearInfoByNumber(number: String) {
        useCases.GetYearInfoUseCase().invoke(number = number).onEach { result ->
            when (result) {

                is Resource.Loading -> {
                    _state.value = FactDetailState(isLoading = true)
                }
                is Resource.Success -> {
                    _state.value = FactDetailState(fact = result.data.toString())
                }
                is Resource.Error -> FactDetailState(
                    error = result.message ?: "An unexpected error occurred"
                )
            }
        }.launchIn(viewModelScope)
    }

    fun getRandomTriviaInfo() {
        useCases.GetRandomTriviaInfoUseCase().invoke().onEach { result ->
            when (result) {

                is Resource.Loading -> {
                    _state.value = FactDetailState(isLoading = true)
                }
                is Resource.Success -> {
                    _state.value = FactDetailState(fact = result.data.toString())
                }
                is Resource.Error -> FactDetailState(
                    error = result.message ?: "An unexpected error occurred"
                )
            }
        }.launchIn(viewModelScope)
    }

    fun getRandomMathInfo() {
        useCases.GetRandomMathInfoUseCase().invoke().onEach { result ->
            when (result) {

                is Resource.Loading -> {
                    _state.value = FactDetailState(isLoading = true)
                }
                is Resource.Success -> {
                    _state.value = FactDetailState(fact = result.data.toString())
                }
                is Resource.Error -> FactDetailState(
                    error = result.message ?: "An unexpected error occurred"
                )
            }
        }.launchIn(viewModelScope)
    }

    fun getRandomDateInfo() {
        useCases.GetRandomDateInfoUseCase().invoke().onEach { result ->
            when (result) {

                is Resource.Loading -> {
                    _state.value = FactDetailState(isLoading = true)
                }
                is Resource.Success -> {
                    _state.value = FactDetailState(fact = result.data.toString())
                }
                is Resource.Error -> FactDetailState(
                    error = result.message ?: "An unexpected error occurred"
                )
            }
        }.launchIn(viewModelScope)
    }

    fun getRandomYearInfo() {
        useCases.GetRandomYearInfoUseCase().invoke().onEach { result ->
            when (result) {

                is Resource.Loading -> {
                    _state.value = FactDetailState(isLoading = true)
                }
                is Resource.Success -> {
                    _state.value = FactDetailState(fact = result.data.toString())
                }
                is Resource.Error -> FactDetailState(
                    error = result.message ?: "An unexpected error occurred"
                )
            }
        }.launchIn(viewModelScope)
    }

    fun handleApiWay(apiWay: ApiWay, viewModel: FactDetailViewModel, vararg args:String) {
        when (apiWay) {

            ApiWay.TRIVIA -> {
                viewModel.getTriviaInfoByNumber(number = args.first().toString())
            }
            ApiWay.MATH -> {
                viewModel.getMathInfoByNumber(year = args.first().toString())
            }
            ApiWay.DATE -> {
                viewModel.getDateInfoByNumber(day = args.first().toString(), month = args.last().toString())
            }
            ApiWay.YEAR -> {
                viewModel.getYearInfoByNumber(number = args.first().toString())
            }
            ApiWay.RANDOM_TRIVIA -> {
                viewModel.getRandomTriviaInfo()
            }
            ApiWay.RANDOM_MATH -> {
                viewModel.getRandomMathInfo()
            }
            ApiWay.RANDOM_DATE -> {
                viewModel.getRandomDateInfo()
            }
            ApiWay.RANDOM_YEAR -> {
                viewModel.getRandomYearInfo()
            }
        }
    }
}