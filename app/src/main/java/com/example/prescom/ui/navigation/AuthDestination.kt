package com.example.prescom.ui.navigation

interface AuthDestination {
    val title: String
    val route: String
}

object AuthInitial : AuthDestination {
    override val title = "Initial"
    override val route = "auth_initial"
}
object AuthLogin : AuthDestination {
    override val title = "Login"
    override val route = "auth_login"
}

object AuthSignUp : AuthDestination {
    override val title = "SignUp"
    override val route = "auth_signup"
}

object AuthForgot : AuthDestination {
    override val title = "Forgot Password"
    override val route = "auth_forgot"
}