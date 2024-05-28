package com.example.prescom.ui.drawer

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun DrawerProjectScreen(
    modifier: Modifier
) {
    val pagerPage = remember { mutableIntStateOf(0) }
    val collectionTabs = remember { mutableListOf("tab 0") }
    (1..2).forEach {
        collectionTabs.add("tab $it")
    }
    val pagerState = rememberPagerState { collectionTabs.count() }
    val coroutineScope = rememberCoroutineScope()

    LaunchedEffect(key1 = pagerState.currentPage) {
        pagerPage.intValue = pagerState.currentPage

    }
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Top
    ) {
        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            IconButton(
                onClick = {
                    collectionTabs.add("tab ${collectionTabs.size + 1}")
                }
            ) {
                Icon(imageVector = Icons.Default.Add, contentDescription = null)
            }

            ScrollableTabRow(
                edgePadding = 0.dp,
                selectedTabIndex = minOf(collectionTabs.count(), pagerPage.intValue),
                tabs = {
                    collectionTabs.forEachIndexed { index, tabName ->
                        Tab(
                            selected = index == pagerState.currentPage,
                            text = { Text(text = tabName) },
                            onClick = {
                                pagerPage.intValue = index
                                coroutineScope.launch { pagerState.animateScrollToPage(index) }
                            }
                        )
                    }
                }
            )
        }
        HorizontalPager(
            state = pagerState,
            modifier = Modifier.fillMaxSize(),
            beyondBoundsPageCount = collectionTabs.count(),
            verticalAlignment = Alignment.CenterVertically,
            userScrollEnabled = true
        ) { tabIndex ->
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text(text = "Android ${collectionTabs[tabIndex]}")
            }
        }
    }

}

@Preview(showBackground = true)
@Composable
private fun DrawerProjectScreenPreview() {
    DrawerProjectScreen(modifier = Modifier.fillMaxSize())
}