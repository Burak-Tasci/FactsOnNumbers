package com.tsci.factsonnumbers.presentation.ui

/*
    This class creates screens in a separated class to have a more readable
    app.
 */
sealed class Screen(val route: String){
    object OptionsListScreen: Screen("options_list_screen")
    object FactDetailScreen: Screen("fact_detail_screen")
}
