@file:OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class,
    ExperimentalMaterial3Api::class
)

package com.davecon.note_y.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import com.davecon.note_y.R

@ExperimentalComposeUiApi
@Composable
fun TitleEntryTextField(width: Int = 0) {
    val keyboardController = LocalSoftwareKeyboardController.current
    var title by remember { mutableStateOf("") }

    TextField(
        modifier = Modifier
            .width(width.dp)
            .padding(16.dp),
        value = title,
        onValueChange = { inputText -> title = inputText },
        label = { Text("Title") },
        placeholder = { Text("Enter Title") },
        keyboardOptions = KeyboardOptions.Default.copy(
            imeAction = ImeAction.Done,
            keyboardType = KeyboardType.Text
        ),
        keyboardActions = KeyboardActions(
            onDone = {
                keyboardController?.hide()
            }
        ),
        colors = TextFieldDefaults.textFieldColors(
            containerColor = Color.White
        ),
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NoteyOutlinedTextField(prompt: String? = null, height: Int = 200, width: Int = 200) {
    var text by remember { mutableStateOf(TextFieldValue("")) }
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
        onValueChange = { input ->
            text = input
        },
        shape = MaterialTheme.shapes.large,
    )
}

@Composable
fun FABAddButton() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.End,
        verticalArrangement = Arrangement.Bottom
    ) {
        IconButton(
            modifier = Modifier
                .padding(8.dp)
                .size(64.dp) // Adjust the size of the IconButton here
                .shadow(24.dp),
            onClick = { /*TODO*/ },
        ) {
            Icon(
                modifier = Modifier.size(64.dp), // Adjust the size of the Icon here
                imageVector = Icons.Filled.AddCircle,
                contentDescription = "Add",
                tint = colorResource(id = R.color.teal)
            )
        }
    }
}
