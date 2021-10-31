package com.mikhailovalx.clientsview.presentation.client.create

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mikhailovalx.clientsview.R
import com.mikhailovalx.clientsview.models.ui.ClientUi
import com.mikhailovalx.clientsview.presentation.PresentationMocks
import com.mikhailovalx.clientsview.presentation.common.IndicatorView
import com.mikhailovalx.clientsview.presentation.common.InputTextView
import com.mikhailovalx.clientsview.presentation.common.StepperView
import com.mikhailovalx.clientsview.theme.PrimaryTextColor
import com.mikhailovalx.clientsview.theme.SecondaryColor
import com.mikhailovalx.clientsview.theme.WhiteColor

@Composable
fun CreateClientScreen(
    onBackPressed: () -> Unit
) {
    CreateClientScreenContent(
        client = ClientUi(
            name = "",
            phone = "",
            isImportant = false
        ),
        isEdit = false,
        title = "",
        onBackPressed = onBackPressed
    )
}

@Composable
fun CreateClientScreenContent(
    client: ClientUi,
    isEdit: Boolean = false,
    title: String,
    onBackPressed: () -> Unit

) {
    var nameFieldState by remember { mutableStateOf("") }
    var phoneFieldState by remember { mutableStateOf("") }
    var birthdayFieldState by remember { mutableStateOf("") }
    var commentFieldState by remember { mutableStateOf("") }

    val scrollState = rememberScrollState()

    val appBarTitle = if (isEdit) {
        stringResource(id = R.string.create_client_title)
    } else {
        stringResource(id = R.string.edit_client_title)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(WhiteColor),
    ) {
        TopAppBar(
            title = { Text(text = appBarTitle, fontSize = 18.sp) },
            contentColor = PrimaryTextColor,
            backgroundColor = WhiteColor,
            navigationIcon = {
                IconButton(onClick = { onBackPressed() }) {
                    Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = null)
                }
            }
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(scrollState),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            IndicatorView(
                modifier = Modifier.padding(30.dp),
                isImportant = client.isImportant,
                backCircleSize = 90.dp,
                frontCircleSize = 66.dp,
                iconWidth = 22.dp,
                iconHeight = 20.dp
            )

            InputTextView(
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
                icon = R.drawable.ic_person,
                title = stringResource(id = R.string.name),
                iconTint = SecondaryColor
            )

            InputTextView(
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
                icon = R.drawable.ic_phone,
                title = stringResource(id = R.string.phone),
                iconTint = SecondaryColor,
                iconHeight = 11.dp,
                iconWidth = 11.dp
            )

            InputTextView(
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
                icon = R.drawable.ic_calendar_check,
                title = stringResource(id = R.string.birthday),
                iconTint = SecondaryColor,
                iconHeight = 11.dp,
                iconWidth = 11.dp
            )

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 8.dp),
                horizontalAlignment = Alignment.Start
            ) {
                StepperView(
                    title = stringResource(id = R.string.count_of_skips),
                    initialValue = 0
                )
            }

            InputTextView(
                modifier = Modifier
                    .padding(horizontal = 16.dp, vertical = 8.dp),
                title = stringResource(id = R.string.comment),
                minHeight = 128.dp
            )
        }
    }
}

@Preview
@Composable
fun CreateClientScreen_Preview() {
    CreateClientScreenContent(
        client = PresentationMocks.client,
        title = stringResource(id = R.string.create_client_title),
        onBackPressed = { }
    )
}