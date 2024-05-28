package com.example.prescom.ui.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.prescom.ui.auth.ForgotPasswordScreen
import com.example.prescom.ui.auth.InitialScreen
import com.example.prescom.ui.auth.LoginScreen
import com.example.prescom.ui.auth.SignUpScreen

fun NavGraphBuilder.authNavGraph(
    rootNavController: NavHostController
) {
    fun onClickNavigateUp(): () -> Unit = { rootNavController.navigateUp() }
    fun onClickDrawerGraph(): () -> Unit = {
        rootNavController.navigate(Graph.DRAWER) {
            popUpTo(AuthLogin.route) { inclusive = true }
        }
    }

    navigation(
        route = Graph.AUTH,
        startDestination = AuthInitial.route
    ) {
        composable(route = AuthInitial.route){
            InitialScreen(
                onClickLoginScreen = {rootNavController.navigate(AuthLogin.route)},
                onClickSignUpScreen = {rootNavController.navigate(AuthSignUp.route)}
            )
        }
        composable(route = AuthLogin.route) {
            LoginScreen(
                onClickDrawerGraph = onClickDrawerGraph(),
                onClickSignUpScreen = { rootNavController.navigate(AuthSignUp.route) },
                onClickForgotPasswordScreen = { rootNavController.navigate(AuthForgot.route) }
            )
        }
        composable(route = AuthSignUp.route) {
            SignUpScreen(
                onClickDrawerGraph = onClickDrawerGraph(),
                onClickNavigateUp = onClickNavigateUp()
            )
        }
        composable(route = AuthForgot.route) {
            ForgotPasswordScreen(
                onClickNavigateUp = onClickNavigateUp()
            )
        }
    }
}








