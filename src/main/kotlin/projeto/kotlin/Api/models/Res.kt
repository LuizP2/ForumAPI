package projeto.kotlin.Api.models

import java.time.LocalDateTime

data class Res ( // data class para armazenar resultados
    val id: Long?,
    val message: String,
    val date: LocalDateTime = LocalDateTime.now(),
    val autor: Usuario,
    val topíco: topico,
    val resultado: Boolean

)
