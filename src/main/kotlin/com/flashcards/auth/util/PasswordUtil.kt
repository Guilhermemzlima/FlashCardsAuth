package com.flashcards.auth.util

import com.toxicbakery.bcrypt.Bcrypt

private const val SALT_ROUNDS = 10

object PasswordUtil {
    fun isValidPassword(password: String, hash: ByteArray): Boolean {
        return Bcrypt.verify(password, hash)
    }

    fun encrypt(password: String): ByteArray {
        return Bcrypt.hash(password, SALT_ROUNDS)
    }
}