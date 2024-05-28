package com.example.prescom.ui.database

import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.prescom.ui.navigation.DatabaseDestination
import com.example.prescom.ui.navigation.databaseDestinations

@Composable
fun DatabaseBottomNavBar(
    items: List<DatabaseDestination>,
    currentRoute: String,
    onClickItem: (DatabaseDestination) -> Unit
) {
    NavigationBar {
        items.forEach { item ->
            NavigationBarItem(
                selected = currentRoute == item.route,
                onClick = { onClickItem(item) },
                icon = {
                    BadgedBox(
                        badge = {
                            if (item.badgeCount != null) {
                                Badge {
                                    Text(text = item.badgeCount.toString())
                                }
                            }
                        }
                    ) {
                        Icon(
                            imageVector = if (currentRoute == item.route) {
                                item.selectedIcon
                            } else {
                                item.unselectedIcon
                            },
                            contentDescription = item.title
                        )
                    }
                },
                label = { Text(text = item.title) },
                alwaysShowLabel = true
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun DatabaseBottomNavBarPreview() {
    DatabaseBottomNavBar(
        items = databaseDestinations,
        currentRoute = databaseDestinations[0].route
    ) {}
}
