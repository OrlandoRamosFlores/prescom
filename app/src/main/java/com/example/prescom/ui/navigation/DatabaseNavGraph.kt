package com.example.prescom.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.prescom.ui.database.DatabaseEquipmentsScreen
import com.example.prescom.ui.database.DatabaseItemsScreen
import com.example.prescom.ui.database.DatabaseLaborScreen
import com.example.prescom.ui.database.DatabaseMaterialsScreen

@Composable
fun DatabaseNavGraph(
    databaseNavController: NavHostController,
    modifier: Modifier
) {
    NavHost(
        navController = databaseNavController,
        route = Graph.DATABASE,
        startDestination = DatabaseItems.route
    ) {
        composable(DatabaseItems.route){
            DatabaseItemsScreen(modifier = modifier)
        }
        composable(DatabaseMaterials.route){
            DatabaseMaterialsScreen(modifier = modifier)
        }
        composable(DatabaseLabor.route){
            DatabaseLaborScreen(modifier = modifier)
        }
        composable(DatabaseEquipments.route){
            DatabaseEquipmentsScreen(modifier = modifier)
        }
    }
}