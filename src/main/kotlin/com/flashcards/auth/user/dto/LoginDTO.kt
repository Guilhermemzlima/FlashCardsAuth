package com.flashcards.auth.user.dto

data class LoginDTO(
    val email: String,
    val password: String,
)