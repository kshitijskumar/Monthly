package com.example.monthly.features.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.monthly.R
import com.example.monthly.ui.theme.Gray

@Composable
fun HomeScreenTabs(
    onClick: (TabTypes) -> Unit = {},
    currSelectedTab: TabTypes
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Spacer(modifier = Modifier.width(4.dp))
        for (tabs in TabTypes.values()) {
            SingleTabComponent(
                tabTypes = tabs,
                onClick = onClick,
                currSelectedTab = currSelectedTab
            )
        }
        Spacer(modifier = Modifier.width(4.dp))
    }
}

@Composable
fun SingleTabComponent(
    tabTypes: TabTypes,
    onClick: (TabTypes) -> Unit = {},
    currSelectedTab: TabTypes
) {
    val resources = LocalContext.current.resources
    val displayMetrics = resources.displayMetrics
    val screenWidth = displayMetrics.widthPixels / displayMetrics.density

    val tabColor = if (currSelectedTab == tabTypes) Gray else Color.White

    Box(
        modifier = Modifier
            .width((screenWidth / 3).dp - 15.dp)
            .aspectRatio(2f)
            .background(tabColor, RoundedCornerShape(20.dp))
            .clickable(
                onClick = { onClick.invoke(tabTypes) },
                enabled = currSelectedTab != tabTypes
            )
            .padding(10.dp, 10.dp),
        contentAlignment = Alignment.Center
    ) {
        Row(
            modifier = Modifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_launcher_foreground),
                contentDescription = null,
                modifier = Modifier
                    .width(20.dp)
                    .aspectRatio(1f)
            )
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = tabTypes.tabText,
                    fontSize = 20.sp,
                )
            }
        }
    }
}

@Preview()
@Composable
fun SingleTabComponentPreview() {
//    SingleTabComponent(TabTypes.EXPENSE)
}

@Preview(showSystemUi = true)
@Composable
fun HomeScreenTabsPreview() {
    HomeScreenTabs(currSelectedTab = TabTypes.ALL)
}

enum class TabTypes(val tabText: String) {
    ALL("All"),
    INCOME("Income"),
    EXPENSE("Expense")
}