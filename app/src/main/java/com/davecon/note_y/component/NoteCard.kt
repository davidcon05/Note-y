package com.davecon.note_y.component

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.davecon.note_y.data.NoteDataSource
import com.davecon.note_y.model.Note

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NoteCard(notes: List<Note>) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
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
            /* TODO */
        }
    ) {
        Surface(
            modifier = Modifier
                .border(1.dp, Color.Black, RoundedCornerShape(corner = CornerSize(12.dp)))
                .padding(8.dp),
            color = Color.White
        ) {
            LazyColumn(Modifier.padding(top = 400.dp)) {
                items(notes) { note ->
                    Text(text = note.title)
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun NoteCardPreview() {
NoteCard(notes = NoteDataSource().loadNotes())
}