package com.example.monthly.features.mainscreen

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.monthly.domain.models.ExpenseModel
import com.example.monthly.features.components.*
import com.example.monthly.utils.DummyData

@ExperimentalFoundationApi
@Composable
fun MainScreen(
    cardClick: (String) -> Unit = {},
    tabClick: (TabTypes) -> Unit = {},
    currSelectedTabTypes: TabTypes
) {
    Scaffold {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()

        ) {
            item {
                Spacer(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(18.dp)
                )
                Row {
                    Spacer(modifier = Modifier.width(18.dp))
                    Greetings(username = "Kshitij")
                }
                Spacer(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(24.dp)
                )
                LazyRow(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    stickyHeader {

                    }
                    items(items = DummyData.dummyCards) { card ->
                        DebitCard(
                            balanceAmount = (0..1000000L).random(),
                            accountNumber = card.cardNumber,
                            holderName = card.holderName,
                            onClick = cardClick
                        )
                    }
                }

            }
            stickyHeader {
                Spacer(
                    modifier = Modifier
                        .height(20.dp)
                        .fillMaxWidth()
                        .background(Color.White)
                )
                HomeScreenTabs(
                    onClick = tabClick,
                    currSelectedTab = currSelectedTabTypes
                )
                Spacer(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(16.dp)
                        .background(Color.White),
                )
            }
            items(DummyData.dummyExpenses) { expense ->
                ExpenseItem(expenseModel = expense)
            }
        }
    }
}

@ExperimentalFoundationApi
@Preview(showSystemUi = true)
@Composable
fun MainScreenPreview() {
    MainScreen(currSelectedTabTypes = TabTypes.ALL)
}