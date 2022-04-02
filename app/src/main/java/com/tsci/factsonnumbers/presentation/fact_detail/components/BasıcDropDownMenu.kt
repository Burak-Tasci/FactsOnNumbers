package com.tsci.factsonnumbers.presentation.fact_detail.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun <T> BasicDropDownMenu(
    currentValue: MutableState<String>,
    listOfItem: List<T>
) {


    val expanded = remember { mutableStateOf(false) }

    Card(
        shape = RoundedCornerShape(20.dp),
        border = BorderStroke(2.dp, MaterialTheme.colors.primary),
        modifier = Modifier
            .padding(8.dp)
            .wrapContentHeight()
    ) {

        Row(
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth()
                .clickable {
                    expanded.value = !expanded.value
                }
        ) {
            Text(text = currentValue.value, Modifier.padding(start = 8.dp))
            Icon(imageVector = Icons.Filled.ArrowDropDown, contentDescription = null)


            DropdownMenu(
                expanded = expanded.value, onDismissRequest = {
                    expanded.value = false
                },
                modifier = Modifier.fillMaxWidth()
            ) {

                listOfItem.forEach {

                    DropdownMenuItem(onClick = {
                        currentValue.value = it.toString()
                        expanded.value = false
                    }) {
                        Text(text = it.toString())
                    }
                }
            }
        }
    }
}