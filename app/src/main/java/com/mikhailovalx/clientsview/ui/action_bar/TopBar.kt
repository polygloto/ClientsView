package com.mikhailovalx.clientsview.ui.action_bar

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mikhailovalx.clientsview.R
import com.mikhailovalx.clientsview.core.theme.BlackColor

@Composable
fun TopBar() {
    TopAppBar(
        title = {
            Text(
                text = stringResource(R.string.app_name),
                fontSize = 18.sp,
                //modifier = Modifier.padding(start = 12.dp)
            )
        },
        backgroundColor = Color.White,
        contentColor = Color.Black,
        elevation = 10.dp,
        actions = {
            SearchButton()
        }
    )
}

@Composable
fun SearchButton() {
    IconButton(
        onClick = { /*TODO*/ }
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_search),
            contentDescription = null,
            tint = BlackColor,
            //modifier = Modifier.padding(end = 20.dp)
        )
    }
}