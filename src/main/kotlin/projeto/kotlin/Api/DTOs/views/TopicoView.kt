package projeto.kotlin.Api.DTOs.views

import projeto.kotlin.Api.models.StatusTopíco
import java.time.LocalDateTime

data class topicoView ( // View que será apresentada no Forum
    val id: Long?,
    val titulo: String,
    val mensagem: String,
    val status: StatusTopíco,
    val dataCriacao: LocalDateTime
)


