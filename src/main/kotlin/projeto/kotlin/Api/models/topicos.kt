package projeto.kotlin.Api.models

import java.time.LocalDateTime

data class Topico( // data class para o objeto topico
    var id: Long? = null,
    val titulo: String,
    val mensagem: String,
    val dataCriacao: LocalDateTime = LocalDateTime.now(),
    val curso: curso,
    val autor: Usuario,
    val status: StatusTopíco = StatusTopíco.NAO_RESPONDIDO,
    val respostas: List<Res> = ArrayList()
)