package com.example.prescom.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.prescom.ui.drawer.DrawerHomeScreen
import com.example.prescom.ui.drawer.DrawerMaterialsScreen
import com.example.prescom.ui.drawer.DrawerProjectScreen
import com.example.prescom.ui.drawer.DrawerShareScreen

@Composable
fun DrawerNavGraph(
    drawerNavController: NavHostController,
    modifier: Modifier
) {
    NavHost(
        navController = drawerNavController,
        route = Graph.DRAWER,
        startDestination = DrawerHome.route
    ) {
        composable(DrawerHome.route){
            DrawerHomeScreen(modifier = modifier)
        }
        composable(DrawerProject.route){
            DrawerProjectScreen(modifier = modifier)
        }
        composable(DrawerDatabase.route){
//            DrawerDatabaseScreen(modifier = modifier)
        }
        composable(DrawerMaterials.route){
            DrawerMaterialsScreen(modifier = modifier)
        }
        composable(DrawerShare.route){
            DrawerShareScreen(modifier = modifier)
        }
    }
}

