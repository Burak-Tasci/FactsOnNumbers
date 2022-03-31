package com.tsci.factsonnumbers.presentation.facts_options

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tsci.factsonnumbers.common.Resource
import com.tsci.factsonnumbers.domain.use_cases.UseCases
import com.tsci.factsonnumbers.presentation.fact_detail.FactDetailState
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

): ViewModel(){



}