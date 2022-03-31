package com.tsci.factsonnumbers.presentation.facts_options

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.tsci.factsonnumbers.presentation.facts_options.components.OptionsListItem
import com.tsci.factsonnumbers.presentation.ui.Screen

/*
    Main screen
 */
@Composable
fun OptionsListScreen(
    navController: NavController,
    viewModel: OptionsListViewModel = hiltViewModel()
) {

    val state = viewModel.state.value
    Surface(
        color = MaterialTheme.colors.background,

        ) {
        Column(
            modifier = Modifier
                .padding(8.dp, 72.dp, 8.dp, 72.dp)
                .fillMaxSize(),

            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            repeat(4) {
                ButtonsRow(
                    onClick1 = {
                        viewModel.getTriviaInfoByNumber("3")
                        navController.navigate(Screen.FactDetailScreen.route + "/${state.fact}")
                },
                    onClick2 = {
                        viewModel.getTriviaInfoByNumber("13")
                        navController.navigate(Screen.FactDetailScreen.route + "/${state.fact}")
                    })
            }
        }
    }
}

@Composable
fun ButtonsRow(
    text1: String = "text1",
    text2: String = "text2",
    onClick1: () -> Unit,
    onClick2: () -> Unit,

    ) {
    Row(
        modifier = Modifier
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        OptionsListItem(itemText = text1, onButtonClick = onClick1)
        OptionsListItem(itemText = text2, onButtonClick = onClick2)
    }
}