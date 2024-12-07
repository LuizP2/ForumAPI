package projeto.kotlin.Api.DTOs.views

import projeto.kotlin.Api.models.Usuario

data class resView(
    val id: Long?,
    val Usuario: Usuario,
    val Topico: topicoView,
    val mensagem: String,
    val solucao: Boolean
    )