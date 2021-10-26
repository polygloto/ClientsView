package com.mikhailovalx.clientsview.presentation.common

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mikhailovalx.clientsview.R
import com.mikhailovalx.clientsview.theme.DividerColor
import com.mikhailovalx.clientsview.theme.LabelTextColor
import com.mikhailovalx.clientsview.theme.TurquoiseColor
import com.mikhailovalx.clientsview.theme.WhiteColor

@Composable
fun LabelView(
    modifier: Modifier = Modifier,
    text: String,
    title: String? = null,
    @DrawableRes icon: Int? = null,
) {
    val textStartPadding = if (icon == null) 16.dp else 10.dp

    Column(modifier = modifier) {
        if (title != null) {
            Text(
                modifier = Modifier.padding(bottom = 8.dp),
                text = title,
                color = LabelTextColor,
                fontSize = 12.sp,
                fontWeight = FontWeight.W600
            )
        }

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .defaultMinSize(minHeight = 50.dp)
                .background(WhiteColor),
            elevation = 4.dp,
            shape = RoundedCornerShape(10.dp)

        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {

                if (icon != null) {
                    Icon(
                        painter = painterResource(id = icon),
                        tint = TurquoiseColor,
                        contentDescription = null,
                        modifier = Modifier.padding(start = 16.dp, end = 10.dp)
                    )

                    Divider(
                        color = DividerColor,
                        modifier = Modifier
                            .width(1.dp)
                            .height(22.dp)
                    )
                }

                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(
                            start = textStartPadding,
                            end = 16.dp,
                            top = 16.dp,
                            bottom = 16.dp
                        ),
                    text = text,
                )
            }
        }
    }


}

@Composable
@Preview
fun LabelView_Preview() {
    LabelView(
        icon = R.drawable.ic_person,
        text = "Михайлов Александр",
        title = "Имя клиента"
    )
}