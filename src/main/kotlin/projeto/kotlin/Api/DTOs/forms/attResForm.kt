package projeto.kotlin.Api.DTOs.forms

import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.Size

data class attResForm (
    @field:NotEmpty var id: Long?,
    @field:NotEmpty @Size(min = 3, max = 100, message = "Deve ter entre 3 e 100 caracteres") val mensagem: String,
    @field:NotEmpty val solucao: Boolean
)