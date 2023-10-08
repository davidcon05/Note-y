package com.davecon.note_y.data

import com.davecon.note_y.model.Note
import java.time.LocalDateTime

class NoteDataSource() {
    fun loadNotes(): List<Note> {
        return listOf(
            Note(
                title = "Note Title1",
                content = "Note 1, super long text to ensure that this only shows on one line",
                entryDate = LocalDateTime.now()
            ),
            Note(
                title = "Note Title2",
                content = "Note2",
                entryDate = LocalDateTime.now()
            ),
            Note(
                title = "Note Title3",
                content = "Note 3, super long text to ensure that this only shows on one line",
                entryDate = LocalDateTime.now()
            ),
            Note(
                title = "Note Title4",
                content = "Not4",
                entryDate = LocalDateTime.now()
            ),
            Note(
                title = "Note Title5",
                content = "Note 5, super long text to ensure that this only shows on one line",
                entryDate = LocalDateTime.now()
            ),
            Note(
                title = "Note Title6",
                content = "Note6",
                entryDate = LocalDateTime.now()
            ),
        )
    }
}