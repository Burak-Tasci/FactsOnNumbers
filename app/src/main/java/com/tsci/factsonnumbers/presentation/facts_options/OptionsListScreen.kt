package com.tsci.factsonnumbers.presentation.facts_options

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.tsci.factsonnumbers.presentation.facts_options.components.OptionsListItem
import com.tsci.factsonnumbers.presentation.ui.Screen
import com.tsci.factsonnumbers.common.ApiWay
/*
    Main screen
 */
@Composable
fun OptionsListScreen(
    navController: NavController,
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
            ButtonsRow(
                text1 = "Trivia Info",
                onClick1 = {
                    navController.navigate(Screen.FactDetailScreen.route + "/${ApiWay.TRIVIA}")
                },
                text2 = "Math Info",
                onClick2 = {
                    navController.navigate(Screen.FactDetailScreen.route + "/${ApiWay.MATH}")
                }
            )
            ButtonsRow(
                text1 = "Date Info",
                onClick1 = {
                    navController.navigate(Screen.FactDetailScreen.route + "/${ApiWay.DATE}")
                },
                text2 = "Year Info",
                onClick2 = {
                    navController.navigate(Screen.FactDetailScreen.route + "/${ApiWay.YEAR}")
                }
            )
            ButtonsRow(
                text1 = "Random Trivia Info",
                onClick1 = {
                    navController.navigate(Screen.FactDetailScreen.route + "/${ApiWay.RANDOM_TRIVIA}")
                },
                text2 = "Random Math Info",
                onClick2 = {
                    navController.navigate(Screen.FactDetailScreen.route + "/${ApiWay.RANDOM_MATH}")
                }
            )
            ButtonsRow(
                text1 = "Random Date Info",
                onClick1 = {
                    navController.navigate(Screen.FactDetailScreen.route + "/${ApiWay.RANDOM_DATE}")
                },
                text2 = "Random Year Info",
                onClick2 = {
                    navController.navigate(Screen.FactDetailScreen.route + "/${ApiWay.RANDOM_YEAR}")
                }
            )

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