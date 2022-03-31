package com.tsci.factsonnumbers.presentation.facts_options

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

/*
    To separate data and ui layer, viewmodel injects UseCases and reaches data layer
    over it. Represents values to ui layer.
 */
@HiltViewModel
class OptionsListViewModel @Inject constructor(
    private val useCases: UseCases
): ViewModel(){

    private val _state = mutableStateOf(OptionsListState())
    val state: State<OptionsListState> = _state


    fun getTriviaInfoByNumber(number: String){
        useCases.GetTriviaInfoUseCase().invoke(number = number).onEach { result ->
            when(result){

                is Resource.Loading -> {
                    _state.value = OptionsListState(isLoading = true)
                }
                is Resource.Success -> {
                    _state.value = OptionsListState(fact = result.toString())
                }
                is Resource.Error -> OptionsListState(
                    error = result.message ?: "An unexpected error occurred"
                )
            }
        }.launchIn(viewModelScope)
    }

}