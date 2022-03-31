package com.tsci.factsonnumbers.presentation.fact_detail

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tsci.factsonnumbers.common.Resource
import com.tsci.factsonnumbers.domain.use_cases.UseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class FactDetailViewModel @Inject constructor(
    private val useCases: UseCases
): ViewModel() {
    private val _state = mutableStateOf(FactDetailState())
    val state: State<FactDetailState> = _state


    fun getTriviaInfoByNumber(number: String){
        useCases.GetTriviaInfoUseCase().invoke(number = number).onEach { result ->
            when(result){

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
}