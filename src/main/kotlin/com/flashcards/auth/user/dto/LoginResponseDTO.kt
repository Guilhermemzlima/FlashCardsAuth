package com.flashcards.auth.user.dto

data class LoginResponseDTO(
    val id: String,
    val jwtToken: String
)