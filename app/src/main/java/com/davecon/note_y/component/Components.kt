@file:OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class)

package com.davecon.note_y.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.davecon.note_y.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InputTextField(
    modifier: Modifier = Modifier,
    titleState: String,
    labelId: String,
    enabled: Boolean = true,
    isSingleLine: Boolean = true,
    keyboardType: KeyboardType = KeyboardType.Text,
    onImeAction: () -> Unit,
    onTextChange: (String) -> Unit = {},
) {
    val keyboardController = LocalSoftwareKeyboardController.current

    TextField(
        value = titleState,
        onValueChange = onTextChange,
        label = { Text(labelId) },
        enabled = enabled,
        textStyle = TextStyle(
            fontSize = 24.sp,
            color = MaterialTheme.colorScheme.onBackground
        ),
        colors = TextFieldDefaults.textFieldColors(
            textColor = colorResource(id = R.color.black),
            containerColor = colorResource(id = R.color.white),
        ),
        singleLine = isSingleLine,
        keyboardOptions = KeyboardOptions(keyboardType = keyboardType, imeAction = ImeAction.Done),
        keyboardActions = KeyboardActions(onDone = {
            onImeAction()
            keyboardController?.hide()
        }),
        modifier = modifier,
    )
}

@Composable
fun NoteyOutlinedTextField(
    modifier: Modifier = Modifier,
    textState: String,
    labelId: String,
    enabled: Boolean = true,
    isSingleLine: Boolean = true,
    keyboardType: KeyboardType = KeyboardType.Text,
    onImeAction: () -> Unit = {},
    onTextChange: (String) -> Unit = {},
) {
    val keyboardController = LocalSoftwareKeyboardController.current

    OutlinedTextField(
        value = textState,
        onValueChange = onTextChange,
        label = { Text(labelId) },
        enabled = enabled,
        textStyle = TextStyle(
            fontSize = 24.sp,
            color = MaterialTheme.colorScheme.onBackground
        ),
        singleLine = isSingleLine,
        keyboardOptions = KeyboardOptions(keyboardType = keyboardType, imeAction = ImeAction.Done),
        keyboardActions = KeyboardActions(onDone = {
            onImeAction()
            keyboardController?.hide()
        }),
        modifier = modifier,
    )
}
@Composable
fun SaveButton(
    modifier: Modifier = Modifier,
    buttonLabel: String,
    onClick: () -> Unit = {},
) {
    Button(
        modifier = Modifier,
        onClick = { onClick }) {
        Text(text = buttonLabel)
    }
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
                .size(64.dp)
                .shadow(24.dp),
            onClick = { /* TODO */ },
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
