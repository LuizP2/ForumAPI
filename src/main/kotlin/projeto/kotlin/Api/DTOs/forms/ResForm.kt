package projeto.kotlin.Api.DTOs.forms

import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.Size
import projeto.kotlin.Api.models.Topico

data class resForm (
    @field:NotEmpty @field:Size(min = 5, max = 110, message = "Deve ter entre 5 e 110 caracteres")
    @field: NotEmpty val mensagem: String,
    val iduser: Long,
    @field: NotEmpty val id: Long,
    val topico: Topico,
    val solucao: Boolean

)
