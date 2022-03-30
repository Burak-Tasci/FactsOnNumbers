package com.tsci.factsonnumbers.presentation.facts_options

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.SavedStateHandle
import com.tsci.factsonnumbers.presentation.facts_options.components.OptionsListItem

@Composable
fun OptionsListScreen(
    viewModel: OptionsListViewModel = hiltViewModel()
) {
    Surface(
        color = MaterialTheme.colors.background,

        ) {
        Column(
            modifier = Modifier
                .padding(8.dp, 72.dp, 8.dp, 72.dp)
                .fillMaxSize(),

            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            repeat(4){
                ButtonsRow(onClick1 = { /*TODO*/ }, onClick2 = {/* TODO */})
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
        OptionsListItem(itemText = "Random Fact", onButtonClick = onClick1)
        OptionsListItem(itemText = "Random Fact", onButtonClick = onClick2)
    }
}