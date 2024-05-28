package com.example.prescom.ui.auth


import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class AuthViewModel : ViewModel() {


    private val _authUiState = MutableStateFlow(AuthUiState())
    val authUiState = _authUiState.asStateFlow()

    fun updateEmail(email: String) {
        _authUiState.value = _authUiState.value.copy(email = email)
    }

    fun updatePassword(password: String) {
        _authUiState.value = _authUiState.value.copy(password = password)
    }

    fun updateConfirmPassword(confirmPassword: String) {
        _authUiState.value = authUiState.value.copy(confirmPassword = confirmPassword)
    }


}