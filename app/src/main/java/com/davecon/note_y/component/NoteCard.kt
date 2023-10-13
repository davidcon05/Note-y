package com.davecon.note_y.component

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.davecon.note_y.data.NoteDataSource
import com.davecon.note_y.model.Note
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@Composable
fun Notes(notes: List<Note>, removeNote: (Note) -> Unit = {}, onRemoveNote: (Note) -> Unit) {
    LazyColumn(modifier = Modifier.fillMaxWidth()) {
        items(notes) { note ->
            //TODO: Change note click to open note in a new screen, add a delete button
            NoteCard(note = note, { removeNote(note) })
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NoteCard(note: Note, removeNote: (Note) -> Unit) {
    Card(
        modifier = Modifier
            .padding(start = 16.dp, end = 16.dp, top = 8.dp, bottom = 8.dp),
        colors = CardDefaults.cardColors(
            contentColor = Color.Black,
            containerColor = Color.White,
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 8.dp,
            pressedElevation = 2.dp,
            focusedElevation = 12.dp,
            hoveredElevation = 4.dp,
            draggedElevation = 4.dp,
            disabledElevation = 0.dp,
        ),
        onClick = {
            removeNote(note)
        }
    ) {

        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .border(1.dp, Color.Black, RoundedCornerShape(corner = CornerSize(12.dp)))
                .padding(8.dp),
            color = Color.White
        ) {
            Column {

                Text(text = note.title, color = Color.Black, fontWeight = FontWeight.Bold)

                Text(text = note.content, maxLines = 1, overflow = TextOverflow.Ellipsis)

                Text(
                    text = formatLocalDateTime(note.entryDate),
                    color = Color.Gray,
                    style = MaterialTheme.typography.labelSmall
                )
            }
        }
    }
}

private fun formatLocalDateTime(localDateTime: LocalDateTime): String {
    val formatter = DateTimeFormatter.ofPattern("MMMM dd, yyyy")
    return localDateTime.format(formatter)
}

@Preview(showBackground = true)
@Composable
fun NotePreview() {
    Notes(notes = NoteDataSource().loadNotes(), onRemoveNote = { })
}