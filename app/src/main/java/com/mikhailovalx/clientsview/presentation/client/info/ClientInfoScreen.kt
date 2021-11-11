package com.mikhailovalx.clientsview.presentation.client.info

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.mikhailovalx.clientsview.R
import com.mikhailovalx.clientsview.presentation.common.ActionButtonView
import com.mikhailovalx.clientsview.presentation.common.AppBar
import com.mikhailovalx.clientsview.presentation.common.LabelView

@Composable
fun ClientInfoScreen(
    clientId: Long,
    navController: NavController
) {
    val title = stringResource(id = R.string.client_info_title)
    ClientInfoScreenContent(
        title = "id = $clientId",
        onBackPressed = { navController.popBackStack() }
    )
}


@Composable
fun ClientInfoScreenContent(
    title: String,
    onBackPressed: () -> Unit
) {


    Scaffold(
        topBar = {
            AppBar(
                title = title,
                onBackPressed = onBackPressed,
                actions = {
                    ActionButtonView(onClick = { }, iconId = R.drawable.ic_delete)
                    ActionButtonView(onClick = { }, iconId = R.drawable.ic_edit)
                }
            )
        }
    ) {
        Column {
            LabelView(
                icon = R.drawable.ic_person,
                text = "",
                title = "Имя клиента",
                modifier = Modifier.padding(top = 16.dp, start = 24.dp, end = 24.dp)
            )

            LabelView(
                icon = R.drawable.ic_calendar_check,
                text = "",
                title = "Дата рождения",
                modifier = Modifier.padding(top = 16.dp, start = 24.dp, end = 24.dp)
            )

            LabelView(
                icon = R.drawable.ic_phone,
                text = "",
                title = "Номер телефона",
                modifier = Modifier.padding(top = 16.dp, start = 24.dp, end = 24.dp)
            )

            //StepperView(stepperValue = 0,
        }
    }
}

@Preview
@Composable
fun ClientInfoScreen_Preview() {
    ClientInfoScreenContent(
        title = "Клиент",
        onBackPressed = { }
    )
}