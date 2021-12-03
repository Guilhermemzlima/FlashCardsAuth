package com.flashcards.auth.util

import com.auth0.jwt.JWT
import com.auth0.jwt.JWTVerifier
import com.auth0.jwt.algorithms.Algorithm
import com.auth0.jwt.interfaces.DecodedJWT
import com.flashcards.auth.user.User
import org.springframework.core.env.Environment
import org.springframework.stereotype.Component

@Component
class JWTUtil(env: Environment) {

    private val algorithm: Algorithm = Algorithm.HMAC256(env.getProperty("JWT_SECRET"))

    private val verifier: JWTVerifier = JWT.require(algorithm)
        .withIssuer("flashcards-auth")
        .build()

    fun generateJwt(user: User): String {
        return JWT.create()
            .withIssuer("flashcards-auth")
            .withSubject(user.id.toString())
            .sign(algorithm)
    }

    fun decodeJwt(token: String): DecodedJWT {
        return verifier.verify(token);
    }


}