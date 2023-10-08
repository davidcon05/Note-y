package com.davecon.note_y.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.davecon.note_y.component.InputTextField
import com.davecon.note_y.component.NoteyOutlinedTextField

@OptIn(ExperimentalComposeUiApi::class)
@Preview(showBackground = true)
@Composable
fun CreateNoteScreen(onValChanged: (String) -> Unit = {}) {
    var titleText = remember { mutableStateOf("") }
    var outlineText = remember { mutableStateOf("") }
    val keyboardController = LocalSoftwareKeyboardController.current

    Column(
        modifier = Modifier
            .padding(top = 8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        InputTextField(
            titleState = titleText,
            labelId = "Title",
            modifier = Modifier
                .padding(start = 16.dp, end = 16.dp, top = 8.dp, bottom = 8.dp)
                .width(440.dp),
            keyboardType = KeyboardType.Text,
            onAction = KeyboardActions(
                onNext = {
                    onValChanged(titleText.value.trim())
                    keyboardController?.hide()
                },
            ),
        )

        NoteyOutlinedTextField(
            modifier = Modifier
                .padding(start = 16.dp, end = 16.dp, top = 8.dp, bottom = 8.dp)
                .width(440.dp)
                .height(200.dp),
            textState = outlineText,
            labelId = "Enter Note",
            isSingleLine = false,
            keyboardType = KeyboardType.Text,
            onAction = KeyboardActions(
                onNext = {
                    onValChanged(outlineText.value.trim())
                    keyboardController?.hide()
                },
            ),
        )

        Button(
            modifier = Modifier
                .padding(16.dp)
                .shadow(16.dp),
            onClick = { /*TODO*/ }) {
            Text(text = "Save")
        }
    }
}