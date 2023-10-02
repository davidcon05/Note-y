package com.davecon.note_y.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.davecon.note_y.component.FABAddButton
import com.davecon.note_y.component.NoteAppBar
import com.davecon.note_y.component.NoteCard
import com.davecon.note_y.component.NoteyOutlinedTextField

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NoteScreen() {
    Scaffold(
        topBar = {
           NoteAppBar()
        }) { _ ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 136.dp),
        ) {
            NoteyOutlinedTextField("Enter Note", width = 440, height = 256)
        }

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 8.dp),
            verticalArrangement = Arrangement.Bottom
        ) {
            item {
                NoteCard(
                    noteTitle = "Note Title1",
                    note = "Note 1, super long text to ensure that this only shows on one line",
                    date = "Date"
                )

                NoteCard(
                    noteTitle = "Note Title2",
                    note = "Note",
                    date = "Date"
                )
            }
        }
        FABAddButton()
    }
}

@Preview(showBackground = true)
@Composable
fun NoteScreenPreview() {
    NoteScreen()
}