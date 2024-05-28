package com.example.prescom.ui.drawer

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.prescom.R
import com.example.prescom.ui.navigation.DrawerDestination
import com.example.prescom.ui.navigation.drawerDestinations
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBarDrawer(
    drawerCurrentScreen: String,
    drawerState: DrawerState,
    coroutineScope: CoroutineScope = rememberCoroutineScope()
) {
    TopAppBar(
        title = { Text(text = drawerCurrentScreen) },
        navigationIcon = {
            IconButton(
                onClick = { coroutineScope.launch { drawerState.open() } }
            ) {
                Icon(imageVector = Icons.Default.Menu, contentDescription = "drawer menu")
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
private fun TopAppBarDrawerPreview() {
    TopAppBarDrawer(
        drawerCurrentScreen = "Drawer Home",
        drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    )
}

@Preview(showBackground = true)
@Composable
fun HeaderSection(
    logo: Painter = painterResource(id = R.drawable.logo),
    text: String = stringResource(id = R.string.app_name)

) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = logo,
            contentDescription = "header logo",
            modifier = Modifier
                .size(100.dp)
        )
        Text(text = text)
    }
}

@Composable
fun BodySection(
    items: List<DrawerDestination>,
    currentRoute: String?,
    onClickItem: (DrawerDestination) -> Unit
) {
    items.forEach { item ->
        NavigationDrawerItem(
            label = { Text(text = item.title) },
            selected = currentRoute == item.route,
            onClick = { onClickItem(item) },
            icon = {
                Icon(
                    imageVector = if (currentRoute == item.route) item.selectedIcon else item.unselectedIcon,
                    contentDescription = item.title
                )
            },
            badge = { item.badgeCount?.let { Text(text = it.toString()) } },
            modifier = Modifier.padding(PaddingValues(horizontal = 12.dp, vertical = 8.dp))
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun BodySectionPreview() {
    BodySection(
        items = drawerDestinations,
        currentRoute = drawerDestinations[1].route
    ) {

    }
}