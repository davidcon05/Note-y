package com.davecon.note_y.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LargeTopAppBar
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarDefaults.exitUntilCollapsedScrollBehavior
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NoteAppBar() {
    val scrollBehavior =
        exitUntilCollapsedScrollBehavior(rememberTopAppBarState())
    val isCollapsed = remember { derivedStateOf { scrollBehavior.state.collapsedFraction > 0.5 } }

    val topAppBarElementColor = if (isCollapsed.value) {
        MaterialTheme.colorScheme.onSurface
    } else {
        MaterialTheme.colorScheme.onPrimary
    }

    val topAppBarAlignText = if (isCollapsed.value) {
        TextAlign.Center
    } else {
        TextAlign.Start
    }

    val collapsedTextSize = 18
    val expandedTextSize = 48
    val topAppBarTextSize =
        (collapsedTextSize + (expandedTextSize - collapsedTextSize) * (1 - scrollBehavior.state.collapsedFraction)).sp

    LargeTopAppBar(
        modifier = Modifier.shadow(16.dp, shape = MaterialTheme.shapes.extraSmall),
        title = {
            Text(
                text = "Notey",
                fontSize = topAppBarTextSize,
                textAlign = topAppBarAlignText, // Center the text vertically,
                modifier = Modifier
                    .fillMaxWidth(), // Center the text horizontally
            )
        },
        //navigationIcon =
        //actions = { AboutActionIcon()}
        colors = TopAppBarDefaults.largeTopAppBarColors(
            scrolledContainerColor = MaterialTheme.colorScheme.surface,
        ),
        scrollBehavior = scrollBehavior
    )

}