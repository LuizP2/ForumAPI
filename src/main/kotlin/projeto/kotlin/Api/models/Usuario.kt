package projeto.kotlin.Api.models


import javax.persistence.*

@Entity
data class Usuario ( // data class do objeto Usuario
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val iduser: Long?,
    val nome: String,
    val email: String
)
