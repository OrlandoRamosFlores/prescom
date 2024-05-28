package com.example.prescom.ui.auth

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.prescom.R

@Preview(showBackground = true)
@Composable
fun SignUpScreen(
    onClickDrawerGraph: () -> Unit = {},
    onClickNavigateUp: () -> Unit = {},
    authViewModel: AuthViewModel = viewModel()
) {
    val authUiState by authViewModel.authUiState.collectAsState()

    AuthContainer {
        AuthHeader("Register")
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
        NormalOutlinedTextField(
            R.string.confirm_password,
            authUiState.confirmPassword,
            { authViewModel.updateConfirmPassword(it) }
        )
        AuthButton("Register", onClickDrawerGraph)
        AuthTextButton("Don't have an account? Regiter", onClickNavigateUp)
    }
}