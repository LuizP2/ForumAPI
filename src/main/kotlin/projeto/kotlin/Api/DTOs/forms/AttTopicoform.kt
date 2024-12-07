package projeto.kotlin.Api.DTOs.forms

import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size

data class AttTopicoform (
    @field:NotNull val id: Long,
    @field:NotEmpty @field:Size(min = 3, max = 100, message = "Deve ter entre 3 e 100 caracteres") val titulo: String,
    @field:NotEmpty val mensagem: String
)

