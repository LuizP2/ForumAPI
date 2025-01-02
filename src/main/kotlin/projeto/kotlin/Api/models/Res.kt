package projeto.kotlin.Api.models

import javax.persistence.*

@Entity
data class Res( // data class para armazenar resultados
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long?,
    val mensagem: String,
    @ManyToOne
    val usuario: Usuario,
    @ManyToOne
    var topico: Topico,
    val solucao: Boolean
    )


