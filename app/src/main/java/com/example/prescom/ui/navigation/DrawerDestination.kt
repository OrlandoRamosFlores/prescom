package com.example.prescom.ui.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.outlined.Create
import androidx.compose.material.icons.outlined.DateRange
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Share
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.ui.graphics.vector.ImageVector

interface DrawerDestination {
    val title: String
    val route: String
    val selectedIcon: ImageVector
    val unselectedIcon: ImageVector
    val badgeCount: Int?
}

val drawerDestinations = listOf(DrawerHome, DrawerProject, DrawerDatabase, DrawerMaterials, DrawerShare)

object DrawerHome: DrawerDestination {
    override val title = "Home"
    override val route = "drawer_home"
    override val selectedIcon = Icons.Filled.Home
    override val unselectedIcon = Icons.Outlined.Home
    override val badgeCount = null
}

object DrawerProject: DrawerDestination {
    override val title = "Project"
    override val route = "drawer_project"
    override val selectedIcon = Icons.Filled.Create
    override val unselectedIcon = Icons.Outlined.Create
    override val badgeCount = null
}
object DrawerDatabase: DrawerDestination {
    override val title = "Database"
    override val route = "drawer_database"
    override val selectedIcon = Icons.Filled.DateRange
    override val unselectedIcon = Icons.Outlined.DateRange
    override val badgeCount = 9
}
object DrawerMaterials: DrawerDestination {
    override val title = "Materials"
    override val route = "drawer_materials"
    override val selectedIcon = Icons.Filled.ShoppingCart
    override val unselectedIcon = Icons.Outlined.ShoppingCart
    override val badgeCount = null
}

object DrawerShare: DrawerDestination {
    override val title = "Share"
    override val route = "drawer_share"
    override val selectedIcon = Icons.Filled.Share
    override val unselectedIcon = Icons.Outlined.Share
    override val badgeCount = null
}

