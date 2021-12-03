package com.flashcards.auth.user

import com.fasterxml.jackson.annotation.JsonIgnore
import java.util.UUID
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "users_table")
data class User(
    @Id
    val id: UUID = UUID.randomUUID(),
    @Column(unique = true)
    val email: String,
    val name: String,
    @JsonIgnore
    val password: ByteArray,
)
