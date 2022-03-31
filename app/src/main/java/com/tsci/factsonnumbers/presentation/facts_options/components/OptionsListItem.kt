package com.tsci.factsonnumbers.presentation.facts_options.components

import android.util.Log
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

/*
    Buttons in OptionsListScreen.kt written here.
 */
@Composable
fun OptionsListItem(
    itemText: String,
    onButtonClick: () -> Unit
) {
    Button(
        onClick = { onButtonClick() },
        Modifier
            .padding(8.dp)
            .height(100.dp),
        shape = RoundedCornerShape(20.dp)

    ) {
        Text(
            text = itemText,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(8.dp),
            fontFamily = FontFamily.Serif
        )
    }
}