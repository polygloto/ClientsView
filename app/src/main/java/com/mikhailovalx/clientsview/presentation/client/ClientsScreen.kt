package com.mikhailovalx.clientsview.presentation.client

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mikhailovalx.clientsview.R
import com.mikhailovalx.clientsview.models.ui.ClientUi
import com.mikhailovalx.clientsview.presentation.common.CircleView
import com.mikhailovalx.clientsview.presentation.common.SemiCircleView
import com.mikhailovalx.clientsview.theme.*

@Composable
fun ClientsScreen(
    viewModel: ClientsViewModel
) {
    val state by viewModel.state.collectAsState()
    when {
        state.data.isNotEmpty() -> ClientsScreenContent(
            clients = state.data,
            onClientClick = { viewModel.sendEvent(ClientsScreenContract.OnClientClickEvent) }
        )
    }
}

@Composable
fun ClientsScreenContent(
    clients: List<ClientUi>,
    onClientClick: () -> Unit,
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
    onClientClick: () -> Unit
) {

    val indicatorColor = if (client.isImportant) GreenAccentColor else TurquoiseColor

    Box(
        modifier = Modifier
            .clickable { onClientClick() }
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

        IndicatorView(indicatorColor)

        Icon(
            painter = painterResource(id = R.drawable.ic_arrow_right),
            tint = TurquoiseColor,
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
            color = SecondaryTextColor,
            fontSize = 12.sp
        )
    }
}

@Composable
fun IndicatorView(
    indicatorColor: Color
) {
    Box(
        modifier = Modifier.padding(vertical = 8.dp),
        contentAlignment = Alignment.Center
    ) {
        SemiCircleView(
            color = indicatorColor,
            size = 54.dp,
        )

        CircleView(
            color = WhiteColor,
            size = 38.dp,
        )

        Icon(
            painter = painterResource(id = R.drawable.ic_heart),
            contentDescription = null
        )
    }
}

@Preview
@Composable
fun ClientsScreen_Preview() {
    IndicatorView(TurquoiseColor)
}