package projeto.kotlin.Api.DTOs

data class novoTopicoForm( // Endpoint que fará o upload de um novo tópico
    val titulo: String,
    val mensagem: String,
    val idCurso: Long,
    val idAutor: Long
)


