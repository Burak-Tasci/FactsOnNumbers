package com.tsci.factsonnumbers.presentation.fact_detail

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController

/*
    Detail screen to represent fact text to user
 */
@Composable
fun FactDetailScreen(
    item: String?
) {

    Text(
        text = item.toString(),
        modifier = Modifier
            .fillMaxSize()
    )

}