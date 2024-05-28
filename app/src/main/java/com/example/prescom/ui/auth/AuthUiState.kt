package com.example.prescom.ui.auth

data class AuthUiState(
    val email: String = "",
    val password: String = "",
    val confirmPassword: String = "",
    val error: String? = null,
    val isLoading: Boolean = false,
    val isLoggedIn: Boolean = false,
    val isPasswordVisible: Boolean = false,
    val isEmailValid: Boolean = false,
    val isPasswordValid: Boolean = false
)
