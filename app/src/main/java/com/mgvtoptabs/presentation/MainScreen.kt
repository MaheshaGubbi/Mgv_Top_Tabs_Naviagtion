package com.mgvtoptabs.presentation

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.PagerState
import com.google.accompanist.pager.pagerTabIndicatorOffset
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.launch
/**
 * Created by Mahesh Gubbi on 31-10-2023.
 * Bengaluru.
 */

@OptIn(ExperimentalPagerApi::class)
@Composable
fun MainScreen() {
    val tabData = getTabList()
    val pagerState = rememberPagerState(pageCount = tabData.size)
    Column(modifier = Modifier.fillMaxSize()) {
        TabLayout(tabData, pagerState)
        TabContent(tabData, pagerState)
    }
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun TabLayout(tabData: List<Pair<String, ImageVector>>, pagerState: PagerState) {

    val scope = rememberCoroutineScope()
/*     val tabColor = listOf(
         Color.Gray,
         Color.Yellow,
         Color.Blue,
         Color.Red,
         Color.Green
     )*/
    TabRow(
        selectedTabIndex = pagerState.currentPage,
        divider = {
            Spacer(modifier =Modifier.height(5.dp))
        },
        indicator = { tabPositions ->
            TabRowDefaults.Indicator(
                modifier = Modifier.pagerTabIndicatorOffset(pagerState, tabPositions),
                height = 3.dp,
                color = Color.Red
            )
        },


        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
    ) {
        tabData.forEachIndexed { index, data ->
            Tab(selected = pagerState.currentPage == index, onClick = {
                scope.launch {
                    pagerState.animateScrollToPage(index)
                }
            },
                icon = {
                    Icon(imageVector = data.second, contentDescription = null)
                },
//                Enable if you want Text
//                text = {
//                    Text(text = data.first, fontSize = 12.sp)
//                }
            )
        }
    }
}


@OptIn(ExperimentalPagerApi::class)
@Composable
fun TabContent(tabData: List<Pair<String, ImageVector>>, pagerState: PagerState) {
    HorizontalPager(state = pagerState) { index ->
        when (index) {
            0 -> {
                MessageScreen()
            }

            1 -> {
                GroupScreen()
            }

            2 -> {
                HomeScreen()
            }

            3 -> {
                NotificationScreen()
            }

            4 -> {
                ProfileScreen()
            }
        }

    }

}


private fun getTabList(): List<Pair<String, ImageVector>> {
    return listOf(
        "Message" to Icons.Default.Email,
        "Group" to Icons.Default.Build,
        "Home" to Icons.Default.Home,
        "Notification" to Icons.Default.Notifications,
        "Profile" to Icons.Default.Person,
    )
}

