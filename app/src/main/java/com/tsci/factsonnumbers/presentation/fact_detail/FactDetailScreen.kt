package com.tsci.factsonnumbers.presentation.fact_detail

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.lifecycle.SavedStateHandle
import com.tsci.cryptocurrencyapp.common.Constants

@Composable
fun FactDetailScreen(
    savedStateHandle: SavedStateHandle
) {
    savedStateHandle.get<String>(Constants.PARAM_FACT)?.let {
        Text(
            text = it
        )
    }
}