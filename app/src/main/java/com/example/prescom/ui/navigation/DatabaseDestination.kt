package com.example.prescom.ui.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FireTruck
import androidx.compose.material.icons.filled.Gite
import androidx.compose.material.icons.filled.Handshake
import androidx.compose.material.icons.filled.HomeWork
import androidx.compose.material.icons.outlined.FireTruck
import androidx.compose.material.icons.outlined.Gite
import androidx.compose.material.icons.outlined.Handshake
import androidx.compose.material.icons.outlined.HomeWork
import androidx.compose.ui.graphics.vector.ImageVector

interface DatabaseDestination {
    val title: String
    val route: String
    val selectedIcon: ImageVector
    val unselectedIcon: ImageVector
    val badgeCount: Int?
}

val databaseDestinations = listOf(DatabaseItems, DatabaseMaterials, DatabaseLabor, DatabaseEquipments)

object DatabaseItems : DatabaseDestination {
    override val title = "Item"
    override val route = "database_item"
    override val selectedIcon = Icons.Filled.HomeWork
    override val unselectedIcon = Icons.Outlined.HomeWork
    override val badgeCount = null
}

object DatabaseMaterials : DatabaseDestination {
    override val title = "Materials"
    override val route = "database_material"
    override val selectedIcon = Icons.Filled.Gite
    override val unselectedIcon = Icons.Outlined.Gite
    override val badgeCount = null
}
object DatabaseLabor: DatabaseDestination {
    override val title = "Labor"
    override val route = "database_labor"
    override val selectedIcon = Icons.Filled.Handshake
    override val unselectedIcon = Icons.Outlined.Handshake
    override val badgeCount = 9
}
object DatabaseEquipments: DatabaseDestination {
    override val title = "Equipment"
    override val route = "database_equipment"
    override val selectedIcon = Icons.Filled.FireTruck
    override val unselectedIcon = Icons.Outlined.FireTruck
    override val badgeCount = null
}

