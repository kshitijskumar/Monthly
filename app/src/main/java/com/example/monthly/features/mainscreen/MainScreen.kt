package com.example.monthly.features.mainscreen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.monthly.features.components.DebitCard
import com.example.monthly.features.components.Greetings

@Composable
fun MainScreen(
    cardClick: (String) -> Unit = {}
) {
    Scaffold {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {
            Greetings(username = "Kshitij")
            Spacer(modifier = Modifier
                .fillMaxWidth()
                .height(18.dp))
            DebitCard(
                balanceAmount = 78000,
                accountNumber = "2212 2120 2009",
                holderName = "Kshitij Kumar",
                onClick = { cardClick.invoke("Kshitij") }
            )
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun MainScreenPreview() {
    MainScreen()
}