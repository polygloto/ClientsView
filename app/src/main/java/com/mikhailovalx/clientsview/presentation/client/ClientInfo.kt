package com.mikhailovalx.clientsview.presentation.client

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.materialIcon
import androidx.compose.material.icons.rounded.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.mikhailovalx.clientsview.navigation.Screen
import com.mikhailovalx.clientsview.navigation.open
import com.mikhailovalx.clientsview.presentation.common.BottomNavigationBar
import com.mikhailovalx.clientsview.theme.GreenAccentColor
import com.mikhailovalx.clientsview.theme.TurquoiseColor
import com.mikhailovalx.clientsview.theme.WhiteColor
import com.mikhailovalx.clientsview.ui.action_bar.TopBar

@Composable
fun ClientInfo() {

    Column {
        Row {
            SimpleOutlinedTextFieldSample()
            SimpleOutlinedTextFieldSample()
        }
        Row {
            SimpleOutlinedTextFieldSample()
            SimpleOutlinedTextFieldSample()
        }
    }



}

@Composable
fun SimpleOutlinedTextFieldSample() {
    var text by remember { mutableStateOf("") }

    OutlinedTextField(
        value = text,
        onValueChange = { text = it },
        label = { Text("Label") },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            unfocusedBorderColor = TurquoiseColor,
            unfocusedLabelColor = TurquoiseColor,
            focusedBorderColor = TurquoiseColor,
            focusedLabelColor = TurquoiseColor
        ),
        trailingIcon = {
            Icon(
                imageVector = Icons.Default.Email,
                contentDescription = "image",
                tint = TurquoiseColor
            )
        },
    )
}