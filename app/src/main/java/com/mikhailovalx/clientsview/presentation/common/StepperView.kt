package com.mikhailovalx.clientsview.presentation.common

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mikhailovalx.clientsview.R
import com.mikhailovalx.clientsview.theme.LabelTextColor
import com.mikhailovalx.clientsview.theme.PrimaryColor
import com.mikhailovalx.clientsview.theme.WhiteColor

@Composable
fun StepperView(
    modifier: Modifier = Modifier,
    title: String? = null,
    onValueChange: (Int) -> Unit,
    stepperValue: Int = 0,
    height: Dp = 54.dp,
    width: Dp = 128.dp,
) {

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
                .height(height)
                .width(width)
                .background(WhiteColor),
            elevation = 4.dp,
            shape = RoundedCornerShape(10.dp)

        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                StepPrevious(
                    modifier = Modifier
                        .fillMaxHeight()
                        .width(50.dp)
                        .clickable { if (stepperValue != 0) { onValueChange(stepperValue.dec()) } }
                )

                Text(text = stepperValue.toString())

                StepNext(
                    modifier = Modifier
                        .fillMaxHeight()
                        .width(50.dp)
                        .clickable { onValueChange(stepperValue.inc()) }
                )
            }
        }
    }
}

@Composable
fun StepPrevious(
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ) {
        CircleView(size = 16.dp, color = PrimaryColor)

        Icon(
            modifier = Modifier.size(8.dp),
            painter = painterResource(R.drawable.ic_minus),
            contentDescription = null,
            tint = WhiteColor,
        )
    }
}

@Composable
fun StepNext(
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ) {
        CircleView(size = 16.dp, color = PrimaryColor)

        Icon(
            modifier = Modifier.size(8.dp),
            painter = painterResource(R.drawable.ic_plus),
            contentDescription = null,
            tint = WhiteColor,
        )
    }
}

@Composable
@Preview
fun StepperView_Preview() {
    StepperView(
        onValueChange = { }
    )
}