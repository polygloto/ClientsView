package com.mikhailovalx.clientsview.presentation.client.list

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.mikhailovalx.clientsview.R
import com.mikhailovalx.clientsview.core.extensions.openWith
import com.mikhailovalx.clientsview.models.client.ClientUi
import com.mikhailovalx.clientsview.navigation.ScreenRoutes
import com.mikhailovalx.clientsview.presentation.PresentationMocks
import com.mikhailovalx.clientsview.presentation.common.IndicatorView
import com.mikhailovalx.clientsview.theme.LabelIconsColor
import com.mikhailovalx.clientsview.theme.PrimaryColor
import com.mikhailovalx.clientsview.theme.PrimaryTextColor

@Composable
fun ClientsScreen(
    navController: NavController,
    viewModel: ClientsViewModel
) {
    val state by viewModel.state.collectAsState()

    ClientsScreenContent(
        clients = state.clients,
        onClientClick = {
            navController.openWith(screen = ScreenRoutes.ClientInfo, param = it)
        }
    )

    LaunchedEffect(key1 = Unit, block = {
        viewModel.sendEvent(ClientsScreenEvent.FetchEvent)
    })
}

@Composable
fun ClientsScreenContent(
    clients: List<ClientUi>,
    onClientClick: (Long) -> Unit,
) {
    LazyColumn {
        items(clients) { client ->
            ClientCard(
                client = client,
                onClientClick = onClientClick
            )
        }
        item {
            Spacer(modifier = Modifier.height(60.dp))
        }
    }
}

@Composable
fun ClientCard(
    client: ClientUi,
    onClientClick: (Long) -> Unit
) {
    Box(
        modifier = Modifier
            .clickable { client.id?.let { onClientClick(it) } }
            .padding(horizontal = 24.dp, vertical = 6.dp)
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 27.dp)
                .height(68.dp),
            elevation = 4.dp,
            shape = RoundedCornerShape(10.dp)
        ) {
            ClientCardText(client.name, client.phone)
        }

        IndicatorView(
            modifier = Modifier.padding(vertical = 8.dp),
            isImportant = client.isImportant,
            isSemiCircle = true
        )

        Icon(
            painter = painterResource(id = R.drawable.ic_arrow_right),
            tint = PrimaryColor,
            contentDescription = null,
            modifier = Modifier
                .align(Alignment.CenterEnd)
                .padding(16.dp)

        )
    }
}

@Composable
fun ClientCardText(name: String, phone: String) {
    Column(
        modifier = Modifier.padding(top = 12.dp, bottom = 12.dp, start = 26.dp)
    ) {
        Text(
            text = name,
            color = PrimaryTextColor,
            fontSize = 14.sp
        )

        Spacer(modifier = Modifier.height(4.dp))

        Text(
            text = phone,
            color = LabelIconsColor,
            fontSize = 12.sp
        )
    }
}

@Preview
@Composable
fun ClientsScreen_Preview() {
    ClientsScreenContent(
        clients = listOf(PresentationMocks.client),
        onClientClick = { }
    )
}