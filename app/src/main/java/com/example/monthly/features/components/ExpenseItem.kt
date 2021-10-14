package com.example.monthly.features.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.monthly.R
import com.example.monthly.domain.models.ExpenseModel
import com.example.monthly.ui.theme.Gray

@Composable
fun ExpenseItem(
    expenseModel: ExpenseModel = ExpenseModel()
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
            .clip(RoundedCornerShape(12.dp))
            .background(Color.White)
            .padding(10.dp, 10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_background),
            contentDescription = null
        )
        Spacer(modifier = Modifier.width(10.dp))
        Row(
            modifier = Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier.fillMaxWidth()
                    .weight(1f),
                verticalArrangement = Arrangement.SpaceEvenly
            ) {
                Text(
                    text = expenseModel.expenseTitle,
                    overflow = TextOverflow.Ellipsis,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    maxLines = 1
                )
                Text(
                    text = expenseModel.timestamp ?: "01 Jan, 1952",
                    overflow = TextOverflow.Ellipsis,
                    color = Gray,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium
                )
            }
            Text(
                text = "${if (expenseModel.isExpense) "-" else "+"}₹${expenseModel.amount}",
                modifier = Modifier.widthIn(max = 80.dp),
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                overflow = TextOverflow.Ellipsis,
                maxLines = 1
            )
        }
    }
}

@Preview
@Composable
fun ExpenseItemPreview() {
    ExpenseItem()
}