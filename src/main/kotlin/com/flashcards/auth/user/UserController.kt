package com.flashcards.auth.user

import com.flashcards.auth.user.dto.LoginDTO
import com.flashcards.auth.user.dto.LoginResponseDTO
import com.flashcards.auth.user.dto.UserSignupDTO
import com.flashcards.auth.util.JWTUtil
import com.flashcards.auth.util.PasswordUtil
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.lang.Exception

@RestController
@RequestMapping("/users")
class UserController(val repository: UserRepository, val jwtUtil: JWTUtil) {

    @PostMapping
    fun create(@RequestBody user: UserSignupDTO): User {
        return repository.save(user.toUserEntity())
    }

    @PostMapping("/login")
    fun login(@RequestBody loginDTO: LoginDTO): LoginResponseDTO {
        val user = repository.findByEmail(loginDTO.email).get()
        if (PasswordUtil.isValidPassword(loginDTO.password, user.password)) {
            return LoginResponseDTO(
                id = user.id.toString(),
                jwtToken = jwtUtil.generateJwt(user)
            )
        } else {
            throw Exception("Email ou senha inválidos")
        }
    }

}