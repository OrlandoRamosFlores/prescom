package com.example.prescom.ui.auth

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.prescom.R

@Composable
fun LoginScreen(
    onClickDrawerGraph: () -> Unit = {},
    onClickSignUpScreen: () -> Unit = {},
    onClickForgotPasswordScreen: () -> Unit = {},
    authViewModel: AuthViewModel = viewModel()
) {
    val authUiState by authViewModel.authUiState.collectAsState()

    AuthContainer {
        AuthHeader("Login")
        NormalOutlinedTextField(
            R.string.email,
            authUiState.email,
            { authViewModel.updateEmail(it) }
        )
        NormalOutlinedTextField(
            R.string.password,
            authUiState.password,
            { authViewModel.updatePassword(it) }
        )
        AuthButton("Login", onClickDrawerGraph)
        AuthTextButton("Don't have an account? Register", onClickSignUpScreen)
        AuthTextButton("Forgot Password", onClickForgotPasswordScreen)
    }
}

@Preview(showBackground = true)
@Composable
private fun LoginScreenPreview() {
    LoginScreen()
}
