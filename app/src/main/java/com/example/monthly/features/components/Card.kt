package com.example.monthly.features.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.*
import com.example.monthly.R

@Composable
fun DebitCard(
    balanceAmount: Long = 0L,
    accountNumber: String = "**** **** ****",
    holderName: String = "Some Rich Guy",
    onClick: ((String) -> Unit) = {}
) {
    Box(
        modifier = Modifier
            .padding(18.dp, 4.dp)
            .fillMaxWidth()
            .aspectRatio(1.65f, false)
            .clip(RoundedCornerShape(10.dp))
            .background(Brush.linearGradient(listOf(Color.Black, Color.Gray)))
            .clickable(onClick = {
                onClick.invoke(holderName)
            })
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
                .padding(8.dp, 4.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(8.dp, 0.dp),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Column {
                    Text(
                        text = "₹ $balanceAmount",
                        modifier = Modifier.fillMaxWidth(),
                        fontSize = 28.sp,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        color = Color.White,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = "Balance",
                        fontSize = 18.sp,
                        color = Color.Gray,
                        modifier = Modifier.padding(4.dp, 0.dp)
                    )
                }
                Column {
                    Text(
                        text = holderName,
                        color = Color.White,
                        fontSize = 24.sp,
                        fontWeight = FontWeight.ExtraBold,
                        modifier = Modifier.padding(0.dp, 4.dp),
                        overflow = TextOverflow.Ellipsis,
                        maxLines = 1
                    )
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = accountNumber,
                            fontSize = 28.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier
                                .weight(1f, true)
                                .padding(5.dp, 0.dp, 5.dp, 4.dp),
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis,
                            color = Color.White
                        )
                        Image(
                            painter = painterResource(id = R.drawable.ic_launcher_foreground),
                            contentDescription = null,
                            modifier = Modifier.size(24.dp),
                            contentScale = ContentScale.FillBounds
                        )
                    }
                }
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun CardPreview() {
    DebitCard(78000)
}