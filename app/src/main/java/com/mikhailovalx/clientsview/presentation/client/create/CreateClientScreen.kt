package com.mikhailovalx.clientsview.presentation.client.create

import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.mikhailovalx.clientsview.R
import com.mikhailovalx.clientsview.core.extensions.showDatePicker
import com.mikhailovalx.clientsview.models.client.ClientUi
import com.mikhailovalx.clientsview.presentation.PresentationMocks
import com.mikhailovalx.clientsview.presentation.common.IndicatorView
import com.mikhailovalx.clientsview.presentation.common.InputTextView
import com.mikhailovalx.clientsview.presentation.common.LabelView
import com.mikhailovalx.clientsview.presentation.common.StepperView
import com.mikhailovalx.clientsview.theme.IndicatorColor
import com.mikhailovalx.clientsview.theme.PrimaryTextColor
import com.mikhailovalx.clientsview.theme.SecondaryColor
import com.mikhailovalx.clientsview.theme.WhiteColor

@Composable
fun CreateClientScreen(
    viewModel: CreateClientViewModel,
    clientId: Long? = null,
    navController: NavController
) {
    val state by viewModel.state.collectAsState()
    val isEdit = clientId != null

    CreateClientScreenContent(
        client = state.client,
        isEdit = isEdit,
        onBackPressed = { navController.popBackStack() },
        onSavePressed = {
            viewModel.sendEvent(CreateClientEvent.OnSaveEvent)
            navController.popBackStack()
        },
        onIndicatorClick = { viewModel.sendEvent(CreateClientEvent.OnIndicatorClicked) },
        onNameChanged = { viewModel.sendEvent(CreateClientEvent.NameChangedEvent(it)) },
        onPhoneChanged = { viewModel.sendEvent(CreateClientEvent.PhoneChangedEvent(it)) },
        onBirthdayChanged = { viewModel.sendEvent(CreateClientEvent.BirthdayChangedEvent(it)) },
        onCommentChanged = { viewModel.sendEvent(CreateClientEvent.CommentChangedEvent(it)) },
        onSkipsChanged = { viewModel.sendEvent(CreateClientEvent.SkipsChangedEvent(it)) }
    )
}

@Composable
fun CreateClientScreenContent(
    client: ClientUi,
    isEdit: Boolean = false,
    onBackPressed: () -> Unit,
    onSavePressed: () -> Unit,
    onIndicatorClick: () -> Unit,
    onNameChanged: (String) -> Unit,
    onPhoneChanged: (String) -> Unit,
    onBirthdayChanged: (Long) -> Unit,
    onCommentChanged: (String) -> Unit,
    onSkipsChanged: (Int) -> Unit,
) {

    val activity = LocalContext.current as AppCompatActivity
    val scrollState = rememberScrollState()
    val updatedDate = { date: Long ->
        onBirthdayChanged(date)
    }

    val appBarTitle = if (isEdit) {
        stringResource(id = R.string.edit_client_title)
    } else {
        stringResource(id = R.string.create_client_title)
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
            },
            actions = {
                IconButton(onClick = onSavePressed) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_check),
                        contentDescription = null
                    )
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
                modifier = Modifier
                    .padding(30.dp)
                    .clip(RoundedCornerShape(50.dp))
                    .clickable { onIndicatorClick() },
                isImportant = client.isImportant,
                backCircleSize = 90.dp,
                frontCircleSize = 66.dp,
                iconWidth = 22.dp,
                iconHeight = 20.dp,
                indicatorOffColor = IndicatorColor
            )

            InputTextView(
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
                textValue = client.name,
                onValueChange = onNameChanged,
                icon = R.drawable.ic_person,
                title = stringResource(id = R.string.name),
                iconTint = SecondaryColor
            )

            InputTextView(
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
                icon = R.drawable.ic_phone,
                textValue = client.phone,
                onValueChange = onPhoneChanged,
                title = stringResource(id = R.string.phone),
                iconTint = SecondaryColor,
                iconHeight = 11.dp,
                iconWidth = 11.dp
            )

            LabelView(
                modifier = Modifier
                    .padding(horizontal = 16.dp, vertical = 8.dp)
                    .clickable(interactionSource = MutableInteractionSource(), indication = null) {
                        activity.showDatePicker(updatedDate)
                    },
                icon = R.drawable.ic_calendar_check,
                title = stringResource(id = R.string.birthday),
                iconTint = SecondaryColor,
                iconHeight = 11.dp,
                iconWidth = 11.dp,
                text = client.stringBirthday
            )

            InputTextView(
                modifier = Modifier
                    .padding(horizontal = 16.dp, vertical = 8.dp),
                title = stringResource(id = R.string.comment),
                textValue = client.comment,
                onValueChange = onCommentChanged,
                icon = R.drawable.ic_comment,
                iconTint = SecondaryColor,
                iconHeight = 12.dp,
                iconWidth = 12.dp
            )

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 8.dp),
                horizontalAlignment = Alignment.Start
            ) {
                StepperView(
                    title = stringResource(id = R.string.count_of_skips),
                    onValueChange = onSkipsChanged,
                    stepperValue = client.skips
                )
            }
        }
    }
}

@Preview
@Composable
fun CreateClientScreen_Preview() {
    CreateClientScreenContent(
        client = PresentationMocks.client,
        isEdit = false,
        onBackPressed = { },
        onIndicatorClick = { },
        onNameChanged = { },
        onPhoneChanged = { },
        onBirthdayChanged = { },
        onCommentChanged = { },
        onSkipsChanged = { },
        onSavePressed = { }
    )
}