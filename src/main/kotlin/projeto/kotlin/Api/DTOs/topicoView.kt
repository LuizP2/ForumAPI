package projeto.kotlin.Api.DTOs

import projeto.kotlin.Api.models.StatusTopíco
import java.time.LocalDateTime

class topicoView ( // View que será apresentada no Forum
    val id: Long?,
    val titulo: String,
    val mensagem: String,
    val status: StatusTopíco,
    val dataCriacao: LocalDateTime
)


