package com.flashcards.auth.user.dto

import com.flashcards.auth.user.User
import com.flashcards.auth.util.PasswordUtil

data class UserSignupDTO(
    val email: String,
    val name: String,
    val password: String,
) {
    fun toUserEntity(): User {
        return User(
            email = email,
            name = name,
            password = PasswordUtil.encrypt(password)
        )
    }
}
