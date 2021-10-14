package com.example.monthly.features.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.monthly.utils.Utils.greetingMsgBasedOnTime

@Composable
fun Greetings(
    time: String = "",
    username: String = "Some Rich Guy"
) {
    Column(
        modifier = Modifier.padding(14.dp, 0.dp)
    ) {
        Text(
            text = "${greetingMsgBasedOnTime(time)}!",
            fontSize = 16.sp,
            fontStyle = FontStyle.Normal,
            color = Color.Gray
        )
        Text(
            text = username,
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            fontSize = 24.sp
        )
    }
}

@Preview(showSystemUi = true)
@Composable
fun GreetingsPreview() {
    Greetings(username = "Kshitij")
}