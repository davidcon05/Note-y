package com.davecon.note_y.component

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NoteyOutlinedTextField(prompt: String? = null, height: Int? = null, width: Int?) {
    var text by remember { mutableStateOf(TextFieldValue("")) }
    if (height != null) {
        if (width != null) {
            OutlinedTextField(
                modifier = Modifier
                    .padding(16.dp)
                    .width(width.dp)
                    .height(height.dp),
                value = text,
                label = {
                    if (prompt != null) {
                        Text(text = prompt)
                    }
                },
                onValueChange = {
                    text = it
                },
                shape = MaterialTheme.shapes.large,
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun NoteyOutlinedTextFieldPreview() {
    NoteyOutlinedTextField("TEST PROMPT", 240, 240)
}