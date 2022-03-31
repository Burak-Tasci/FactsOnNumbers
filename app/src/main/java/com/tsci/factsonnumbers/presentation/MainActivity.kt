package com.tsci.factsonnumbers.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.tsci.factsonnumbers.R
import com.tsci.factsonnumbers.presentation.fact_detail.FactDetailScreen
import com.tsci.factsonnumbers.presentation.facts_options.OptionsListScreen
import com.tsci.factsonnumbers.presentation.ui.Screen
import com.tsci.factsonnumbers.presentation.ui.theme.FactsOnNumbersTheme
import dagger.hilt.android.AndroidEntryPoint

/*
    App's starting screen is determining here. MainActivity.kt class is building skeleton
    of UI and configures navigation.
 */
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            val scaffoldState = rememberScaffoldState()
            FactsOnNumbersTheme {
                // A surface container using the 'background' color from the theme
                Scaffold(
                    scaffoldState = scaffoldState,
                    topBar = {
                        TopAppBar(
                            elevation = 8.dp
                        ) {
                            Text(
                                text = stringResource(id = R.string.app_name),
                                style = MaterialTheme.typography.h4,
                                fontFamily = FontFamily.Serif,
                                textAlign = TextAlign.Left,
                                modifier = Modifier
                                    .padding(8.dp)
                            )
                        }
                    }
                ) {
                    Surface(
                        modifier = Modifier.fillMaxSize(),
                        color = MaterialTheme.colors.background
                    ) {
                        App()
                    }
                }
            }
        }
    }
}

@Composable
fun App(){
    val navController = rememberNavController()
    NavHost(
        navController =  navController,
        startDestination = Screen.OptionsListScreen.route
    ){
        composable(
            route = Screen.OptionsListScreen.route
        ){
            OptionsListScreen(navController)
        }
        composable(
            route = Screen.FactDetailScreen.route + "/{fact}",
            arguments = listOf(
                navArgument("fact"){
                    type = NavType.StringType
                }
            )
        ){  item ->

            FactDetailScreen(
                item = item.arguments?.getString("fact")
            )
        }
    }
}