package com.tsci.factsonnumbers.presentation.fact_detail

/*
    To be able to control api request response
 */
data class FactDetailState(
    val isLoading: Boolean = false,
    val fact: String = "",
    val error: String = ""
)