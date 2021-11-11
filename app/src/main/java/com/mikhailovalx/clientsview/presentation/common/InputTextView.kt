package com.mikhailovalx.clientsview.presentation.common

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mikhailovalx.clientsview.R
import com.mikhailovalx.clientsview.theme.*

@Composable
fun InputTextView(
    modifier: Modifier = Modifier,
    title: String? = null,
    textValue: String,
    @DrawableRes icon: Int? = null,
    onValueChange: (String) -> Unit,
    iconTint: Color = PrimaryColor,
    iconHeight: Dp = 10.dp,
    iconWidth: Dp = 10.dp,
    minHeight: Dp = 54.dp
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
                .height(IntrinsicSize.Min)
                .defaultMinSize(minHeight = minHeight)
                .background(WhiteColor),
            elevation = 4.dp,
            shape = RoundedCornerShape(10.dp)

        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {

                if (icon != null) {
                    Icon(
                        modifier = Modifier
                            .padding(start = 16.dp, end = 10.dp)
                            .size(height = iconHeight, width = iconWidth),
                        painter = painterResource(id = icon),
                        tint = iconTint,
                        contentDescription = null
                    )

                    Divider(
                        color = DividerColor,
                        modifier = Modifier
                            .width(1.dp)
                            .fillMaxHeight()
                            .padding(vertical = 14.dp)
                    )
                }

                BasicTextField(
                    modifier = Modifier
                        .padding(start = textStartPadding, end = 16.dp, top = 16.dp, bottom = 16.dp)
                        .fillMaxWidth(),
                    value = textValue,
                    onValueChange = onValueChange,
                    cursorBrush = SolidColor(PrimaryColor),
                )
            }
        }
    }
}

@Composable
@Preview
fun InputTextView_Preview() {
    InputTextView(
        icon = R.drawable.ic_person,
        title = "Имя клиента",
        iconTint = LabelIconsColor,
        textValue = "",
        onValueChange = { }
    )
}