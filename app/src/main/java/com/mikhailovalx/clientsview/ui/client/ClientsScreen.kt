package com.mikhailovalx.clientsview

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mikhailovalx.clientsview.core.theme.*
import com.mikhailovalx.clientsview.data.Client
import com.mikhailovalx.clientsview.core.mock.ClientsMock

@Composable
fun ClientsScreen() {
    LazyColumn {
        items(ClientsMock.clientList) { client ->
            ClientCard(client = client)
        }
        item {
            Spacer(modifier = Modifier.height(60.dp))
        }
    }
}

@Composable
fun ClientCard(client: Client) {

    val indicatorColor = if (client.isImportant) TurquoiseColor else GreenAccentColor

    Box {
        CircleShape(
            indicatorColor,
            size = 54.dp,
            paddingStart = 12.dp,
            paddingTop = 14.dp
        )

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 42.dp, end = 12.dp, top = 8.dp, bottom = 8.dp)
                .height(68.dp),
            elevation = 5.dp,
            shape = RoundedCornerShape(10.dp)
        ) {
            ClientCardInfo(client.name, client.phone)
        }

        CircleShape(
            color = WhiteColor,
            size = 38.dp,
            paddingStart = 20.dp,
            paddingTop = 22.dp
        )

        Icon(
            painter = painterResource(id = R.drawable.ic_heart),
            contentDescription = null,
            Modifier.padding(start = 32.dp, top = 35.dp)
        )

        Icon(
            painter = painterResource(id = R.drawable.ic_arrow_right),
            tint = TurquoiseColor,
            contentDescription = null,
            modifier = Modifier.align(Alignment.CenterEnd)
                .padding(end = 28.dp)
        )
    }
}

@Composable
fun ClientCardInfo(name: String, phone: String) {
    Column(
        modifier = Modifier.padding(top = 12.dp, bottom = 12.dp, start = 26.dp)
    ) {
        Text(
            buildAnnotatedString {
                withStyle(style = SpanStyle(color = PrimaryTextColor, fontSize = 14.sp)) {
                    append(name)
                }
            }
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            buildAnnotatedString {
                withStyle(style = SpanStyle(color = SecondaryTextColor, fontSize = 12.sp)) {
                    append(phone)
                }
            }
        )
    }
}

@Composable
fun CircleShape(
    color: Color,
    size: Dp,
    paddingTop: Dp,
    paddingStart: Dp
) {
    Card(
        modifier = Modifier.padding(top = paddingTop, start = paddingStart),
        shape = androidx.compose.foundation.shape.CircleShape,
        elevation = 3.dp
    ) {
        Canvas(
            modifier = Modifier.size(size),
            onDraw = { drawCircle(color = color) }
        )
    }
}