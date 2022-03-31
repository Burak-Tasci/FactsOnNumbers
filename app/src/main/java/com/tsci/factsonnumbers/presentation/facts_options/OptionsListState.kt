package com.tsci.factsonnumbers.presentation.facts_options

/*
    To be able to control api request response
 */
data class OptionsListState(
    val isLoading: Boolean = false,
    val fact: String = "",
    val error: String = ""
)