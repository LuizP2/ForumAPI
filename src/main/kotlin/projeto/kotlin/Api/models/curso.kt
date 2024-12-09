package projeto.kotlin.Api.models

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
data class curso ( // Data class do objeto curso
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val idcurso: Long? = null,
    val nome: String,
    val categoria: String
)
