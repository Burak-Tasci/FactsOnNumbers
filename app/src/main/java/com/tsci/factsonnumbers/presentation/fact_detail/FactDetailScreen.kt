package com.tsci.factsonnumbers.presentation.fact_detail


import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.tsci.factsonnumbers.common.ApiWay
import com.tsci.factsonnumbers.presentation.fact_detail.components.BasicDropDownMenu


/*
    Detail screen to represent fact text to user
 */
@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun FactDetailScreen(
    apiWay: ApiWay,
    viewModel: FactDetailViewModel = hiltViewModel()
) {
    val context = LocalContext.current
    val keyboardController = LocalSoftwareKeyboardController.current

    var visibilityFirst: Boolean = true
    var visibilitySecond: Boolean = false


    val textFieldInputFirst: MutableState<String> = rememberSaveable { mutableStateOf("") }
    val textFieldInputSecond: MutableState<String> = rememberSaveable { mutableStateOf("") }


    val modifier: Modifier = Modifier
        .padding(8.dp)
        .fillMaxWidth()

    if (viewModel.state.value.isLoading) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            CircularProgressIndicator()
        }
    }
    if (viewModel.state.value.error.isNotEmpty()) {
        Text(
            text = viewModel.state.value.error,
            color = Color.Red
        )
    }

    Surface(
        color = MaterialTheme.colors.background
    ) {
        Column {
            Card(
                shape = RoundedCornerShape(20.dp),
                border = BorderStroke(2.dp, MaterialTheme.colors.primary),
                modifier = modifier
                    .wrapContentHeight()
            ) {
                Text(
                    text = viewModel.state.value.fact,
                    modifier = Modifier.padding(16.dp),
                    style = MaterialTheme.typography.h5,
                    fontStyle = FontStyle.Italic,
                    fontFamily = FontFamily.Serif
                )
            }

            when (apiWay) {
                ApiWay.DATE -> {
                    visibilitySecond = true
                }
                ApiWay.TRIVIA, ApiWay.YEAR, ApiWay.MATH -> {
                    visibilitySecond = false
                }
                else -> {
                    visibilityFirst = false;visibilitySecond = false
                }
            }

            if (visibilityFirst) {
                when (apiWay) {
                    ApiWay.YEAR -> {
                        OutlinedTextField(
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number, imeAction = ImeAction.Done),
                            value = textFieldInputFirst.value,
                            keyboardActions = KeyboardActions(onDone = {
                                keyboardController?.hide()
                            }),
                            singleLine = true,
                            onValueChange = { textFieldInputFirst.value = it.filter { it != '\n' } },
                            shape = RoundedCornerShape(20.dp),
                            label = { Text(text = "Year") },
                            modifier = modifier
                        )
                    }
                    ApiWay.TRIVIA, ApiWay.MATH -> {
                        OutlinedTextField(
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number, imeAction = ImeAction.Done),
                            value = textFieldInputFirst.value,
                            keyboardActions = KeyboardActions(onDone = {
                               keyboardController?.hide()
                            }),
                            singleLine = true,
                            onValueChange = { textFieldInputFirst.value = it.filter { it != '\n' } },
                            shape = RoundedCornerShape(20.dp),
                            label = { Text(text = "Number") },
                            modifier = modifier
                        )
                    }
                    else -> {
                        Text(
                            text = "Day",
                            textAlign = TextAlign.Center,
                            color = MaterialTheme.colors.primary,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(),
                            textDecoration = TextDecoration.Underline
                        )
                        BasicDropDownMenu(currentValue = textFieldInputFirst,
                            listOfItem = IntArray(31) { it + 1 }.map {
                                it.toString()
                            })
                    }
                }
            }
            if (visibilitySecond) {
                Text(
                    text = "Month",
                    textAlign = TextAlign.Center,
                    color = MaterialTheme.colors.primary,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(),
                    textDecoration = TextDecoration.Underline
                )
                BasicDropDownMenu(currentValue = textFieldInputSecond,
                    listOfItem = IntArray(12) { it + 1 }.map {
                        it.toString()
                    })
            }

            OutlinedButton(
                onClick = {
                    when (apiWay) {
                        ApiWay.DATE -> {
                            if (isDateValid(
                                    textFieldInputFirst.value.toIntOrNull(),
                                    textFieldInputSecond.value.toIntOrNull()
                                ) && (textFieldInputFirst.value.isNotBlank() && textFieldInputSecond.value.isNotBlank())
                            ) {
                                viewModel.handleApiWay(
                                    apiWay = apiWay,
                                    viewModel = viewModel,
                                    args = arrayOf(textFieldInputFirst, textFieldInputSecond)
                                )
                            } else {
                                showMessage(context, "Invalid Date!")
                            }
                        }
                        ApiWay.TRIVIA, ApiWay.MATH, ApiWay.YEAR -> {
                            if (textFieldInputFirst.value.isNotBlank()) {
                                viewModel.handleApiWay(
                                    apiWay = apiWay,
                                    viewModel = viewModel,
                                    args = arrayOf(textFieldInputFirst, textFieldInputSecond)
                                )
                            } else {
                                showMessage(context, "Invalid Number!")
                            }
                        }
                        else -> {
                            viewModel.handleApiWay(
                                apiWay = apiWay,
                                viewModel = viewModel,
                                args = arrayOf(textFieldInputFirst, textFieldInputSecond)
                            )
                        }

                    }
                },

                modifier = modifier
            ) {
                Text(text = "GET")

            }

        }
    }


}


private fun isDateValid(day: Int?, month: Int?): Boolean {

    val dayMonthPairs: HashMap<Int, List<Int>> = HashMap<Int, List<Int>>()

    with(dayMonthPairs) {
        put(1, IntArray(31) { it + 1 }.toList())
        put(2, IntArray(29) { it + 1 }.toList())
        put(3, IntArray(31) { it + 1 }.toList())
        put(4, IntArray(30) { it + 1 }.toList())
        put(5, IntArray(31) { it + 1 }.toList())
        put(6, IntArray(30) { it + 1 }.toList())
        put(7, IntArray(31) { it + 1 }.toList())
        put(8, IntArray(31) { it + 1 }.toList())
        put(9, IntArray(30) { it + 1 }.toList())
        put(10, IntArray(31) { it + 1 }.toList())
        put(11, IntArray(30) { it + 1 }.toList())
        put(12, IntArray(31) { it + 1 }.toList())
    }

    return dayMonthPairs.get(month)?.contains(day) == true

}

fun showMessage(context: Context, message: String) {
    Toast.makeText(context, message, Toast.LENGTH_LONG).show()
}
