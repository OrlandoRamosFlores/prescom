package com.example.prescom.ui.navigation

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.prescom.ui.database.DatabaseBottomNavBar
import com.example.prescom.ui.drawer.BodySection
import com.example.prescom.ui.drawer.HeaderSection
import com.example.prescom.ui.drawer.TopAppBarDrawer
import kotlinx.coroutines.launch

@Composable
fun DrawerMainScreen(
    rootNavController: NavHostController,
    drawerNavController: NavHostController = rememberNavController(),
    databaseNavController: NavHostController = rememberNavController()
) {
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val coroutineScope = rememberCoroutineScope()

    //Setting for Drawer
    val drawerNavBackStackEntry by drawerNavController.currentBackStackEntryAsState()
    val drawerCurrentDestination = drawerNavBackStackEntry?.destination
    val drawerCurrentScreen =
        drawerDestinations.find { it.route == drawerCurrentDestination?.route }
            ?: drawerDestinations[0]
    //Setting for Database
    val databaseNavBackStackEntry by databaseNavController.currentBackStackEntryAsState()
    val databaseCurrentDestination = databaseNavBackStackEntry?.destination
    val databaseCurrentScreen =
        databaseDestinations.find { it.route == databaseCurrentDestination?.route }
            ?: databaseDestinations[0]


    ModalNavigationDrawer(
        gesturesEnabled = drawerState.isOpen,
        drawerContent = {
            ModalDrawerSheet {
                HeaderSection()
                Spacer(modifier = Modifier.height(8.dp))
                BodySection(
                    items = drawerDestinations,
                    currentRoute = drawerCurrentScreen.route
                ) {
                    drawerNavController.navigateSingleTopTo(it.route)
                    coroutineScope.launch { drawerState.close() }
                }
            }
        },
        drawerState = drawerState
    ) {
        Scaffold(
            topBar = {
                TopAppBarDrawer(
                    drawerCurrentScreen = drawerCurrentScreen.route,
                    drawerState = drawerState
                )
            },
            bottomBar = {
                if (drawerCurrentScreen.route == drawerDestinations[2].route) {
                    DatabaseBottomNavBar(
                        items = databaseDestinations,
                        currentRoute = databaseCurrentScreen.route,
                        onClickItem = { databaseNavController.navigateSingleTopTo(it.route) }
                    )
                }
            }
        ) { innerPadding ->
            DrawerNavGraph(
                drawerNavController = drawerNavController,
                modifier = Modifier.padding(innerPadding)
            )
            if (drawerCurrentScreen.route == drawerDestinations[2].route) {
                DatabaseNavGraph(
                    databaseNavController = databaseNavController,
                    modifier = Modifier.padding(innerPadding)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun DrawerScreenPreview() {
    DrawerMainScreen(rootNavController = rememberNavController())
}