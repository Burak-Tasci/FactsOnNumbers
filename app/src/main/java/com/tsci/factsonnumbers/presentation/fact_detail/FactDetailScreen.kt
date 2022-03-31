package com.tsci.factsonnumbers.presentation.fact_detail



import android.os.Bundle
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel
import com.tsci.factsonnumbers.common.ApiWay

/*
    Detail screen to represent fact text to user
 */
@Composable
fun FactDetailScreen(
    apiWay: ApiWay,
    viewModel: FactDetailViewModel = hiltViewModel()
) {

    when(apiWay){

        ApiWay.TRIVIA -> {
            viewModel.getTriviaInfoByNumber("3")
            if (viewModel.state.value.isLoading){
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier.fillMaxSize()
                ) {
                    CircularProgressIndicator()
                }
            }
            if (viewModel.state.value.error.isNotEmpty()){
                Text(
                    text = viewModel.state.value.error,
                    color = Color.Red
                )
            }
            if (viewModel.state.value.fact.isNotEmpty()){
                Text(
                    text = viewModel.state.value.fact
                )
            }
        }
        ApiWay.MATH -> {
            Text(text = "MATH")
        }
        ApiWay.DATE -> {
            Text(text = "DATE")
        }
        ApiWay.YEAR -> {
            Text(text = "YEAR")
        }
        ApiWay.RANDOM_TRIVIA -> {
            Text(text = "RANDOM_TRIVIA")
        }
        ApiWay.RANDOM_MATH -> {
            Text(text = "RANDOM_MATH")
        }
        ApiWay.RANDOM_DATE -> {
            Text(text = "RANDOM_DATE")
        }
        ApiWay.RANDOM_YEAR -> {
            Text(text = "RANDOM_YEAR")
        }
    }

}