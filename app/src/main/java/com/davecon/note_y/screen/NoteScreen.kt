package com.davecon.note_y.screen

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.davecon.note_y.component.InputTextField
import com.davecon.note_y.component.Notes
import com.davecon.note_y.component.NoteyAppBar
import com.davecon.note_y.component.NoteyOutlinedTextField
import com.davecon.note_y.component.SaveButton
import com.davecon.note_y.data.NoteDataSource
import com.davecon.note_y.model.Note

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NoteScreen(
    onAddNote: (Note) -> Unit,
    onRemoveNote: (Note) -> Unit,
    notes: List<Note>,
) {
    var noteTitle by remember { mutableStateOf("") }
    var noteContent by remember { mutableStateOf("") }
    val context = LocalContext.current

    Scaffold(
        topBar = {
            NoteyAppBar()
        }
    ) { _ ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 56.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            InputTextField(
                titleState = noteTitle,
                labelId = "Title",
                modifier = Modifier
                    .padding(start = 16.dp, end = 16.dp, top = 8.dp, bottom = 8.dp)
                    .width(440.dp),
                isSingleLine = false,
                onImeAction = {},
                onTextChange = {
                    if (it.all { char -> char.isLetterOrDigit() || char.isWhitespace() })
                        noteTitle = it
                },
            )

            NoteyOutlinedTextField(
                modifier = Modifier
                    .padding(start = 16.dp, end = 16.dp, top = 8.dp, bottom = 8.dp)
                    .width(440.dp)
                    .height(200.dp),
                textState = noteContent,
                labelId = "Add a note",
                isSingleLine = false,
                keyboardType = KeyboardType.Text,
                onTextChange = {
                    if (it.all { char -> char.isLetterOrDigit() || char.isWhitespace() }) noteContent =
                        it
                },
            )

            SaveButton(
                modifier = Modifier
                    .padding(16.dp)
                    .align(Alignment.CenterHorizontally)
                    .shadow(16.dp),
                buttonLabel = "Save"
            ) {
                if (noteTitle.isNotEmpty() && noteContent.isNotEmpty()) {
                    // save and add to list
                    onAddNote(Note(title = noteTitle, content = noteContent))
                    // clear fields
                    noteTitle = ""
                    noteContent = ""
                    Toast.makeText(context, "Note saved", Toast.LENGTH_SHORT).show()
                }

            } // End save Button
            Divider(modifier = Modifier.padding(16.dp).shadow(16.dp))

            Notes(notes = notes, onRemoveNote = {onRemoveNote(it)})


        } // End Column


    } // End Content
        // TODO: Tap to reveal note input fields
    //FABAddButton()
} // End NoteScreen

@Preview(showBackground = true)
@Composable
fun NoteScreenPreview() {
    NoteScreen(onAddNote = { NoteDataSource().loadNotes() }, onRemoveNote = {}, notes = listOf())
}