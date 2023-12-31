package com.davecon.note_y.model

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.LocalDateTime
import java.util.UUID

data class Note @RequiresApi(Build.VERSION_CODES.O) constructor(
    val id: UUID = UUID.randomUUID(),
    val title: String,
    val content: String,
    val entryDate: LocalDateTime = LocalDateTime.now(),
)
