package projeto.kotlin.Api.models

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
data class usuario ( // data class do objeto Usuario
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val iduser: Long?,
    val nome: String,
    val email: String
)
