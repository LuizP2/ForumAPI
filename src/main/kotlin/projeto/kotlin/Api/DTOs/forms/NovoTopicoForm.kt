package projeto.kotlin.Api.DTOs.forms

import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size

data class novoTopicoForm( // Endpoint que fará o upload de um novo tópico
    @field:NotEmpty @field:Size(min = 5, max = 110, message = "Deve ter entre 5 e 110 caracteres") val titulo: String,
    @field:NotEmpty val mensagem: String,
    @field:NotNull val idCurso: Long,
    @field:NotNull val idAutor: Long
)


