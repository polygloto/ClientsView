package com.mikhailovalx.clientsview.presentation.client.info

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.mikhailovalx.clientsview.R
import com.mikhailovalx.clientsview.core.extensions.openWith
import com.mikhailovalx.clientsview.core.extensions.toStringDate
import com.mikhailovalx.clientsview.models.client.ClientUi
import com.mikhailovalx.clientsview.navigation.ScreenRoutes
import com.mikhailovalx.clientsview.presentation.PresentationMocks
import com.mikhailovalx.clientsview.presentation.common.*
import com.mikhailovalx.clientsview.theme.IndicatorColor
import com.mikhailovalx.clientsview.theme.PrimaryColor

@Composable
fun ClientInfoScreen(
    viewModel: ClientInfoViewModel = hiltViewModel(),
    clientId: Long,
    navController: NavController
) {
    val state by viewModel.state.collectAsState()

    ClientInfoScreenContent(
        onBackPressed = { navController.popBackStack() },
        onEditButtonClicked = { navController.openWith(ScreenRoutes.CreateEditClient, clientId) },
        onDeleteButtonClicked = {
            viewModel.sendEvent(ClientInfoEvent.DeleteClientEvent)
            navController.popBackStack()
        },
        client = state.client
    )

    LaunchedEffect(key1 = Unit, block = {
        viewModel.sendEvent(ClientInfoEvent.FetchEvent(clientId))
    })
}


@Composable
fun ClientInfoScreenContent(
    client: ClientUi,
    onBackPressed: () -> Unit,
    onEditButtonClicked: () -> Unit,
    onDeleteButtonClicked: () -> Unit
) {

    val scrollState = rememberScrollState()

    Scaffold(
        topBar = {
            AppBar(
                title = stringResource(id = R.string.client_info_title),
                onBackPressed = onBackPressed,
                actions = {
                    ActionButtonView(onClick = onDeleteButtonClicked, iconId = R.drawable.ic_delete)
                    ActionButtonView(onClick = onEditButtonClicked, iconId = R.drawable.ic_edit)
                }
            )
        }
    ) {
        Column(
            modifier = Modifier.verticalScroll(scrollState),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier
                    .padding(top = 30.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                RoundedButtonView(
                    modifier = Modifier
                        .padding(end = 24.dp)
                        .clickable { },
                    iconId = R.drawable.ic_fast_message
                )

                IndicatorView(
                    iconWidth = 22.dp,
                    iconHeight = 20.dp,
                    backCircleSize = 90.dp,
                    frontCircleSize = 64.dp,
                    isImportant = client.isImportant,
                    indicatorOffColor = IndicatorColor
                )

                RoundedButtonView(
                    modifier = Modifier
                        .padding(start = 24.dp)
                        .clickable { },
                    iconId = R.drawable.ic_fast_call
                )
            }

            LabelView(
                icon = R.drawable.ic_person,
                text = client.name,
                title = stringResource(id = R.string.name),
                modifier = Modifier.padding(top = 28.dp, start = 16.dp, end = 16.dp)
            )

            LabelView(
                icon = R.drawable.ic_phone,
                text = client.phone,
                title = stringResource(id = R.string.phone),
                modifier = Modifier.padding(top = 16.dp, start = 16.dp, end = 16.dp)
            )

            LabelView(
                icon = R.drawable.ic_calendar_check,
                text = client.birthday.toStringDate(),
                title = stringResource(id = R.string.birthday),
                modifier = Modifier.padding(top = 16.dp, start = 16.dp, end = 16.dp)
            )

            Row(
                modifier = Modifier
                    .padding(top = 16.dp, start = 16.dp, end = 16.dp)
                    .fillMaxWidth()
            ) {
                NumberView(
                    title = stringResource(id = R.string.count_of_visits),
                    number = 0 // TODO кол-во посещений должно браться из таблицы с событиями
                )

                NumberView(
                    modifier = Modifier.padding(start = 48.dp),
                    title = stringResource(id = R.string.count_of_skips),
                    number = client.skips
                )
            }

            LabelView(
                modifier = Modifier
                    .padding(16.dp),
                title = stringResource(id = R.string.comment),
                text = client.comment,
                icon = R.drawable.ic_comment,
                iconTint = PrimaryColor,
                iconHeight = 12.dp,
                iconWidth = 12.dp
            )
        }
    }
}

@Preview
@Composable
fun ClientInfoScreen_Preview() {
    ClientInfoScreenContent(
        onBackPressed = { },
        onEditButtonClicked = { },
        onDeleteButtonClicked = { },
        client = PresentationMocks.client
    )
}