package projeto.kotlin.Api.DTOs.forms

import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.Size

data class attResForm (
    @field:NotEmpty var id: Long?,
    @field:NotEmpty @Size(min = 3, max = 100) val mensagem: String,
    @field:NotEmpty val solucao: Boolean
)