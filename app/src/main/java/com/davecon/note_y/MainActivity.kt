package com.davecon.note_y

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.davecon.note_y.screen.NoteScreen
import com.davecon.note_y.ui.theme.NoteyTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NoteyTheme {
                // A surface container using the 'background' color from the theme
                NoteyApp {
                }
            }
        }
    }
}

@Composable
fun NoteyApp(content: @Composable () -> Unit) {
    NoteyTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            NoteScreen(onAddNote = {}, onRemoveNote = {}, notes = listOf())
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    NoteyTheme {
        NoteyApp {
        }
    }
}