package com.example.monthly

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.monthly.features.components.DebitCard
import com.example.monthly.features.components.TabTypes
import com.example.monthly.features.mainscreen.MainScreen
import com.example.monthly.ui.theme.MonthlyTheme
import com.example.monthly.ui.theme.OffWhite

class MainActivity : ComponentActivity() {
    @ExperimentalFoundationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MonthlyTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = OffWhite) {
                    var selectedTab by remember {
                        mutableStateOf(TabTypes.ALL)
                    }
                    MainScreen(
                        cardClick = {
                            Toast.makeText(this, "Holder is $it", Toast.LENGTH_LONG).show()
                        },
                        tabClick = {
                            selectedTab = it
                        },
                        currSelectedTabTypes = selectedTab
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@ExperimentalFoundationApi
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview() {
    MonthlyTheme {
        MainScreen(currSelectedTabTypes = TabTypes.ALL)
    }
}