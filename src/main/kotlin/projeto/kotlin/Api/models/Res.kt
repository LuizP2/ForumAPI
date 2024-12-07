package projeto.kotlin.Api.models

import projeto.kotlin.Api.DTOs.views.topicoView

data class Res( // data class para armazenar resultados
    var id: Long?,
    val mensagem: String,
    val usuario: Usuario,
    var topico: topicoView,
    val solucao: Boolean
    )


