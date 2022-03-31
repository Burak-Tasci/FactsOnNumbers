package com.tsci.factsonnumbers.presentation


import android.content.res.Configuration.UI_MODE_NIGHT_YES
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.tsci.factsonnumbers.R
import com.tsci.factsonnumbers.common.ApiWay
import com.tsci.factsonnumbers.presentation.fact_detail.FactDetailScreen
import com.tsci.factsonnumbers.presentation.facts_options.OptionsListScreen
import com.tsci.factsonnumbers.presentation.ui.Screen
import com.tsci.factsonnumbers.presentation.ui.theme.FactsOnNumbersTheme
import dagger.hilt.android.AndroidEntryPoint


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

@Preview("Light Mode")
@Preview(
    name = "Dark Mode",
    uiMode = UI_MODE_NIGHT_YES,
    showBackground = true
)
@Composable
fun App() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Screen.OptionsListScreen.route
    ) {
        composable(
            route = Screen.OptionsListScreen.route
        ) {
            OptionsListScreen(navController)
        }
        composable(
            route = Screen.FactDetailScreen.route + "/{select}",
            arguments = listOf(
                navArgument("select"){
                    type = NavType.inferFromValueType(ApiWay.TRIVIA)
                }
            )
        ) {
            val apiWay: ApiWay = (it.arguments?.get("select") as ApiWay ?: null) as ApiWay
            FactDetailScreen(apiWay = apiWay)
        }
    }
}