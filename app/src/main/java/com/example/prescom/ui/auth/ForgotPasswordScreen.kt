package com.example.prescom.ui.auth

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.prescom.R

@Preview(showBackground = true)
@Composable
fun ForgotPasswordScreen(
    onClickNavigateUp: () -> Unit = {}
) {
    AuthContainer {
        AuthHeader(text = "Reset Password")
        NormalOutlinedTextField(R.string.password, value = "New Password", {})
        AuthButton(text = "Reset Password", onClick = onClickNavigateUp)
    }
}