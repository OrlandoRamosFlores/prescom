package com.example.prescom.ui.auth

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun InitialScreen(
    onClickLoginScreen: () -> Unit = {},
    onClickSignUpScreen: () -> Unit = {}
) {
    AuthContainer {
        AuthHeader("Welcome to Prescom")
        Spacer(modifier = Modifier.height(80.dp))

        AuthButton( "Login", onClickLoginScreen)
        AuthButton( "Register", onClickSignUpScreen)

    }
}

@Preview(showBackground = true)
@Composable
private fun LoginScreenPreview() {
    InitialScreen()
}
