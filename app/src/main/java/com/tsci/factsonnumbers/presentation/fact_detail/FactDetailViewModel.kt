package com.tsci.factsonnumbers.presentation.fact_detail

import androidx.compose.runtime.MutableState
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

    fun getDateInfoByNumber(day: String, month: String) {
        useCases.GetDateInfoUseCase().invoke(
            day = day,
            month = month
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

    fun handleApiWay(apiWay: ApiWay, viewModel: FactDetailViewModel, vararg args: MutableState<String>): Boolean {
        when (apiWay) {

            ApiWay.TRIVIA -> {
                if (args.first().toString()
                        .isNotBlank()
                ) viewModel.getTriviaInfoByNumber(number = args.first().value); return true
            }
            ApiWay.MATH -> {
                if (args.first().toString()
                        .isNotBlank()
                ) viewModel.getMathInfoByNumber(year = args.first().value); return true
            }
            ApiWay.DATE -> {
                if (args.first().value.isNotBlank() && args.last().value
                        .isNotBlank()
                ) viewModel.getDateInfoByNumber(
                    day = args.last().value,
                    month = args.first().value
                ); return true
            }
            ApiWay.YEAR -> {
                if (args.first().toString()
                        .isNotBlank()
                ) viewModel.getYearInfoByNumber(number = args.first().value); return true
            }
            ApiWay.RANDOM_TRIVIA -> {
                viewModel.getRandomTriviaInfo(); return true
            }
            ApiWay.RANDOM_MATH -> {
                viewModel.getRandomMathInfo(); return true
            }
            ApiWay.RANDOM_DATE -> {
                viewModel.getRandomDateInfo(); return true
            }
            ApiWay.RANDOM_YEAR -> {
                viewModel.getRandomYearInfo(); return true
            }
        }
        return false
    }
}