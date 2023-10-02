package com.davecon.note_y.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.davecon.note_y.R

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
                .size(64.dp) // Adjust the size of the IconButton here
                .shadow(24.dp),
            onClick = { /*TODO*/ },
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