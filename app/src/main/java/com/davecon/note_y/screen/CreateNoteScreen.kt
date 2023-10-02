package com.davecon.note_y.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.davecon.note_y.component.NoteyOutlinedTextField
import com.davecon.note_y.component.TitleEntryTextField

@Preview(showBackground = true)
@Composable
fun CreateNoteScreen() {
    Column(
        modifier = Modifier
            .padding(top = 8.dp, start = 16.dp, end = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        TitleEntryTextField()
        NoteyOutlinedTextField("Enter Note",width = 440, height = 256)
        Button(
            modifier = Modifier.padding(16.dp).shadow(16.dp),
            onClick = { /*TODO*/ }) {
            Text(text = "Save")
        }
    }
}