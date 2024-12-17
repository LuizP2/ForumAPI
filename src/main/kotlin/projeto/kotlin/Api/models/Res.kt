package projeto.kotlin.Api.models

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.ManyToOne

@Entity
data class Res( // data class para armazenar resultados
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long?,
    val mensagem: String,
    @ManyToOne
    val usuario: usuario,
    @ManyToOne
    var topico: Topico,
    val solucao: Boolean
    )


